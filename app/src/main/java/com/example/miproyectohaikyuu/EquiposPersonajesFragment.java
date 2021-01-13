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

import com.bumptech.glide.Glide;
import com.example.miproyectohaikyuu.databinding.FragmentEquiposPersonajesBinding;
import com.example.miproyectohaikyuu.databinding.ViewholderEquiposBinding;

import java.util.List;

public class EquiposPersonajesFragment extends Fragment {

    FragmentEquiposPersonajesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentEquiposPersonajesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EquiposPosicionesViewModel equiposPosicionesViewModel = new ViewModelProvider(this).get(EquiposPosicionesViewModel.class);

        final EquiposPersonajesFragment.EquiposAdapter equiposAdapter = new EquiposPersonajesFragment.EquiposAdapter();

        binding.recyclerEquipoPosiciones.setAdapter(equiposAdapter);

        equiposPosicionesViewModel.equipoposicion().observe(getViewLifecycleOwner(), new Observer<List<EquipoPosicion>>() {
            @Override
            public void onChanged(List<EquipoPosicion> equipoPosicion) {
                equiposAdapter.setEquipoList(equipoPosicion);
            }
        });
    }

    class EquiposAdapter extends RecyclerView.Adapter<EquiposPersonajesFragment.EquiposViewHolder>{

        List<EquipoPosicion> equipoList;
        @NonNull
        @Override
        public EquiposViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new EquiposPersonajesFragment.EquiposViewHolder(ViewholderEquiposBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull EquiposViewHolder holder, int position) {
            EquipoPosicion equipoPosicion = equipoList.get(position);

            Glide.with(EquiposPersonajesFragment.this).load(equipoPosicion.foto).into(holder.binding.foto);
            holder.binding.nombre.setText(equipoPosicion.nombre);
            holder.binding.posicion.setText(equipoPosicion.posicion);
        }

        @Override
        public int getItemCount() {
            return equipoList == null ? 0 : equipoList.size();
        }

        void setEquipoList(List<EquipoPosicion> equipoList){
            this.equipoList = equipoList;
            notifyDataSetChanged();
        }
    }

    class EquiposViewHolder extends RecyclerView.ViewHolder{

        ViewholderEquiposBinding binding;

        public EquiposViewHolder(@NonNull ViewholderEquiposBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}