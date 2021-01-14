package com.example.miproyectohaikyuu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miproyectohaikyuu.databinding.FragmentPosicionesPersonajesBinding;
import com.example.miproyectohaikyuu.databinding.ViewholderPosicionesBinding;
import com.example.miproyectohaikyuu.model.EquipoPosicion;
import com.example.miproyectohaikyuu.viewmodel.EquiposPosicionesViewModel;

import java.util.List;

public class PosicionesPersonajesFragment extends Fragment {

    FragmentPosicionesPersonajesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentPosicionesPersonajesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EquiposPosicionesViewModel equiposPosicionesViewModel = new ViewModelProvider(this).get(EquiposPosicionesViewModel.class);

        final PosicionesAdapter posicionesAdapter = new PosicionesAdapter();

        binding.recyclerEquipoPosiciones.setAdapter(posicionesAdapter);

        equiposPosicionesViewModel.equipoposicion().observe(getViewLifecycleOwner(), new Observer<List<EquipoPosicion>>() {
            @Override
            public void onChanged(List<EquipoPosicion> equipoPosicion) {
                posicionesAdapter.setEquipoPosicionList(equipoPosicion);
            }
        });
    }

    class PosicionesAdapter extends RecyclerView.Adapter<PosicionViewHolder>{
        List<EquipoPosicion> equipoPosicionList;
        @NonNull
        @Override
        public PosicionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PosicionViewHolder(ViewholderPosicionesBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull PosicionViewHolder holder, int position) {
            EquipoPosicion equipoPosicion = equipoPosicionList.get(position);

           /* Glide.with(PosicionesPersonajesFragment.this).load(.foto).into(holder.binding.foto);
            holder.binding.nombre.setText(equipoPosicion.nombre);
            holder.binding.equipo.setText(equipoPosicion.equipo);*/
        }

        @Override
        public int getItemCount() {
            return equipoPosicionList == null ? 0 : equipoPosicionList.size();
        }

        void setEquipoPosicionList(List<EquipoPosicion> equipoPosicionList){
            this.equipoPosicionList = equipoPosicionList;
            notifyDataSetChanged();
        }
    }

    class PosicionViewHolder extends RecyclerView.ViewHolder{

        ViewholderPosicionesBinding binding;

        public PosicionViewHolder(@NonNull ViewholderPosicionesBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}