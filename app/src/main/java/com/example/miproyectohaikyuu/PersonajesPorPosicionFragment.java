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
import com.example.miproyectohaikyuu.databinding.FragmentPersonajesPorPosicionBinding;
import com.example.miproyectohaikyuu.databinding.ViewholderPersonajePorPosicionBinding;
import com.example.miproyectohaikyuu.model.PersonajeConEquipo;
import com.example.miproyectohaikyuu.model.Posicion;
import com.example.miproyectohaikyuu.viewmodel.HaikyuuViewModel;

import java.util.List;

public class PersonajesPorPosicionFragment extends Fragment {

    private FragmentPersonajesPorPosicionBinding binding;
    HaikyuuViewModel haikyuuViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentPersonajesPorPosicionBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        haikyuuViewModel = new ViewModelProvider(requireActivity()).get(HaikyuuViewModel.class);
        navController = Navigation.findNavController(view);

        PersonajesAdapter personajesAdapter = new PersonajesAdapter();

        binding.recyclerPosicion.setAdapter(personajesAdapter);
        binding.recyclerPosicion.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        haikyuuViewModel.posicionSeleccionado().observe(getViewLifecycleOwner(), posicion -> {

            Glide.with(PersonajesPorPosicionFragment.this).load(posicion.fotoPosicion).into(binding.escudoPosicion);
            binding.nombrePosicion.setText(posicion.nombrePosicion);

            obtenerPersonajes(posicion).observe(getViewLifecycleOwner(), personajes -> personajesAdapter.establecerLista(personajes));
        });

        binding.irAtras.setOnClickListener(v -> navController.popBackStack());
    }

    LiveData<List<PersonajeConEquipo>> obtenerPersonajes(Posicion posicion){
        return haikyuuViewModel.obtenerPersonajesPorPosicion(posicion);
    }


    class PersonajesAdapter extends RecyclerView.Adapter<PersonajeViewHolder>{
        List<PersonajeConEquipo> personajes;

        @NonNull
        @Override
        public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PersonajeViewHolder(ViewholderPersonajePorPosicionBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
            PersonajeConEquipo personaje = personajes.get(position);

            holder.binding.nombre.setText(personaje.nombre);
            holder.binding.equipo.setText(personaje.nombreEquipo);

            Glide.with(PersonajesPorPosicionFragment.this).load(personaje.foto).into(holder.binding.foto);

            holder.itemView.setOnClickListener(v -> {
                haikyuuViewModel.seleccionar(personaje);
                navController.navigate(R.id.action_global_personajesFragment);
            });
        }

        @Override
        public int getItemCount() {
            return personajes != null ? personajes.size() : 0;
        }

        public void establecerLista(List<PersonajeConEquipo> personajes){
            this.personajes = personajes;
            notifyDataSetChanged();
        }

    }

    static class PersonajeViewHolder extends RecyclerView.ViewHolder {
        final ViewholderPersonajePorPosicionBinding binding;

        public PersonajeViewHolder(@NonNull ViewholderPersonajePorPosicionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}