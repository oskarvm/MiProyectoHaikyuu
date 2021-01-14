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

import com.example.miproyectohaikyuu.databinding.FragmentPersonajesBinding;
import com.example.miproyectohaikyuu.databinding.ViewholderPersonajeBinding;
import com.example.miproyectohaikyuu.model.Personaje;


public class PersonajesFragment extends Fragment {
    private FragmentPersonajesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPersonajesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PersonajesViewModel personajesViewModel = new ViewModelProvider(requireActivity()).get(PersonajesViewModel.class);

        personajesViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<Personaje>() {
            @Override
            public void onChanged(Personaje personaje) {
                binding.nombre.setText(personaje.nombre);
                binding.posicion.setText(personaje.posicion);
            }
        });
    }

    static class PersonajeViewHolder extends RecyclerView.ViewHolder {
        final ViewholderPersonajeBinding binding;

        public PersonajeViewHolder(@NonNull ViewholderPersonajeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

/*class PersonajesAdapter extends RecyclerView.Adapter<PersonajeViewHolder>{

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

    static class PersonajeViewHolder extends RecyclerView.ViewHolder{

        ViewholderPersonajeBinding binding;

        public PersonajeViewHolder(@NonNull ViewholderPersonajeBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }*/
