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
import com.example.miproyectohaikyuu.databinding.FragmentPersonajePorEquipoBinding;
import com.example.miproyectohaikyuu.databinding.ViewholderPersonajePorEquipoBinding;
import com.example.miproyectohaikyuu.model.Equipo;
import com.example.miproyectohaikyuu.model.PersonajeConEquipo;
import com.example.miproyectohaikyuu.viewmodel.HaikyuuViewModel;

import java.util.List;

public class PersonajesPorEquipoFragment extends Fragment {

    private FragmentPersonajePorEquipoBinding binding;
    HaikyuuViewModel haikyuuViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentPersonajePorEquipoBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        haikyuuViewModel = new ViewModelProvider(requireActivity()).get(HaikyuuViewModel.class);
        navController = Navigation.findNavController(view);

        PersonajesAdapter personajesAdapter = new PersonajesAdapter();

        binding.recyclerEquipo.setAdapter(personajesAdapter);
        binding.recyclerEquipo.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        haikyuuViewModel.equipoSeleccionado().observe(getViewLifecycleOwner(), equipo -> {

            Glide.with(PersonajesPorEquipoFragment.this).load(equipo.escudo).into(binding.escudoEquipo);
            binding.nombreEquipo.setText(equipo.nombreEquipo);

            obtenerPersonajes(equipo).observe(getViewLifecycleOwner(), personajes -> personajesAdapter.establecerLista(personajes));
        });
    }

    LiveData<List<PersonajeConEquipo>> obtenerPersonajes(Equipo equipo){
        return haikyuuViewModel.obtenerPersonajesPorEquipo(equipo);
    }


    class PersonajesAdapter extends RecyclerView.Adapter<PersonajeViewHolder>{
        List<PersonajeConEquipo> personajes;

        @NonNull
        @Override
        public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PersonajeViewHolder(ViewholderPersonajePorEquipoBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
            PersonajeConEquipo personaje = personajes.get(position);

            holder.binding.nombre.setText(personaje.nombre);
            holder.binding.posicion.setText(personaje.posicion);

            Glide.with(PersonajesPorEquipoFragment.this).load(personaje.foto).into(holder.binding.foto);

            holder.itemView.setOnClickListener(v -> {
                haikyuuViewModel.seleccionar(personaje);
                navController.navigate(R.id.action_global_personajesFragment);
            });

            binding.irAtras.setOnClickListener(v -> navController.popBackStack());
        }

        @Override
        public int getItemCount() {
            return personajes != null ? personajes.size() : 0;
        }

        public void establecerLista(List<PersonajeConEquipo> personajes){
            this.personajes = personajes;
            notifyDataSetChanged();
        }

        /*public Personaje obtenerPersonaje(int posicion){
            return personajes.get(posicion);
        }*/
    }

    static class PersonajeViewHolder extends RecyclerView.ViewHolder {
        final ViewholderPersonajePorEquipoBinding binding;

        public PersonajeViewHolder(@NonNull ViewholderPersonajePorEquipoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}