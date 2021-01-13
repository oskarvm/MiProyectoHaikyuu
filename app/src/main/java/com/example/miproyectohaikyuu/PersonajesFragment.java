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
import com.example.miproyectohaikyuu.databinding.FragmentPersonajesBinding;
import com.example.miproyectohaikyuu.databinding.ViewholderPersonajeBinding;
import com.example.miproyectohaikyuu.model.Personaje;

import java.util.List;

public class PersonajesFragment extends Fragment {

    FragmentPersonajesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPersonajesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PersonajesViewModel personajesViewModel = new ViewModelProvider(this).get(PersonajesViewModel.class);

        final PersonajesAdapter personajesAdapter = new PersonajesAdapter();

        binding.recyclerView.setAdapter(personajesAdapter);

        personajesViewModel.personajes().observe(getViewLifecycleOwner(), new Observer<List<Personaje>>() {
            @Override
            public void onChanged(List<Personaje> personajes) {
                personajesAdapter.setPersonajeList(personajes);
            }
        });

        //personajesViewModel.obtener().observe(getViewLifecycleOwner(), personajesAdapter::setPersonajeList);
    }

    class PersonajesAdapter extends RecyclerView.Adapter<PersonajeViewHolder>{

        List<Personaje> personajeList;

        @NonNull
        @Override
        public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PersonajeViewHolder(ViewholderPersonajeBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
            Personaje personaje = personajeList.get(position);

            Glide.with(PersonajesFragment.this).load(personaje.foto).into(holder.binding.foto);
            Glide.with(PersonajesFragment.this).load(personaje.escudo).into(holder.binding.escudo);
            holder.binding.nombre.setText(personaje.nombre);
            holder.binding.posicion.setText(personaje.posicion);
            holder.binding.equipo.setText(personaje.equipo);
            holder.binding.altura.setText(personaje.altura);
            holder.binding.bloqueo.setText(personaje.bloqueo);
            holder.binding.remate.setText(personaje.remate);
            holder.binding.recepcion.setText(personaje.recepcion);
            holder.binding.saque.setText(personaje.saque);
            holder.binding.colocacion.setText(personaje.colocacion);
        }

        @Override
        public int getItemCount() {
            return personajeList == null ? 0 : personajeList.size();
        }

        void setPersonajeList(List<Personaje> personajeList){
            this.personajeList = personajeList;
            notifyDataSetChanged();
        }
    }

    class PersonajeViewHolder extends RecyclerView.ViewHolder{

        ViewholderPersonajeBinding binding;

        public PersonajeViewHolder(@NonNull ViewholderPersonajeBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}