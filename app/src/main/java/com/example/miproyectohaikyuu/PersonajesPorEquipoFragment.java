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
import com.example.miproyectohaikyuu.databinding.FragmentEquiposPersonajesBinding;

import com.example.miproyectohaikyuu.databinding.ViewholderPersonajePorEquipoBinding;
import com.example.miproyectohaikyuu.model.Personaje;
import com.example.miproyectohaikyuu.model.PersonajeConEquipo;
import com.example.miproyectohaikyuu.viewmodel.PersonajesViewModel;

import java.util.List;

public class PersonajesPorEquipoFragment extends Fragment {

    private FragmentEquiposPersonajesBinding binding;
    PersonajesViewModel personajesViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentEquiposPersonajesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        personajesViewModel  = new ViewModelProvider(requireActivity()).get(PersonajesViewModel.class);
        navController = Navigation.findNavController(view);

        PersonajesAdapter personajesAdapter;
        personajesAdapter = new PersonajesAdapter();

        binding.recyclerView.setAdapter(personajesAdapter);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        obtenerPersonaje().observe(getViewLifecycleOwner(), personajes -> personajesAdapter.establecerLista(personajes));
    }

    LiveData<List<PersonajeConEquipo>> obtenerPersonaje(){
        return personajesViewModel.obtener();
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
                personajesViewModel.seleccionar(personaje);
                navController.navigate(R.id.action_global_personajesFragment);
            });
        }

        @Override
        public int getItemCount() {
            return personajes != null ? personajes.size() : 0;
        }

        public void establecerLista(List<PersonajeConEquipo> elementos){
            this.personajes = elementos;
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