package com.example.miproyectohaikyuu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.miproyectohaikyuu.databinding.FragmentListaEquiposBinding;
import com.example.miproyectohaikyuu.databinding.ViewholderListaEquiposBinding;
import com.example.miproyectohaikyuu.model.Equipo;
import com.example.miproyectohaikyuu.viewmodel.HaikyuuViewModel;

import java.util.List;

public class ListaEquiposFragment extends Fragment {

    private FragmentListaEquiposBinding binding;
    HaikyuuViewModel haikyuuViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentListaEquiposBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        haikyuuViewModel = new ViewModelProvider(requireActivity()).get(HaikyuuViewModel.class);
        navController = Navigation.findNavController(requireParentFragment().requireView());


        PersonajesAdapter personajesAdapter = new PersonajesAdapter();

        binding.recyclerListaEquipos.setAdapter(personajesAdapter);
        binding.recyclerListaEquipos.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        obtenerEquipo().observe(getViewLifecycleOwner(), equipos -> personajesAdapter.establecerLista(equipos));
    }

    LiveData<List<Equipo>> obtenerEquipo(){
        return haikyuuViewModel.obtenerEquipo();
    }

    class PersonajesAdapter extends RecyclerView.Adapter<PersonajeViewHolder>{
        List<Equipo> equipos;

        @NonNull
        @Override
        public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PersonajeViewHolder(ViewholderListaEquiposBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
            Equipo equipo = equipos.get(position);

            holder.binding.equipo.setText(equipo.nombreEquipo);
            Glide.with(ListaEquiposFragment.this).load(equipo.escudo).into(holder.binding.imagenEquipo);

            holder.itemView.setOnClickListener(v -> {
                haikyuuViewModel.seleccionarEquipo(equipo);
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_personajesPorEquipoFragment);
            });
        }

        //Size equipos
        @Override
        public int getItemCount() {
            return equipos != null ? equipos.size() : 0;
        }

        public void establecerLista(List<Equipo> equipos){
            this.equipos = equipos;
            notifyDataSetChanged();
        }

    }

    static class PersonajeViewHolder extends RecyclerView.ViewHolder {
        final ViewholderListaEquiposBinding binding;

        public PersonajeViewHolder(@NonNull ViewholderListaEquiposBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}