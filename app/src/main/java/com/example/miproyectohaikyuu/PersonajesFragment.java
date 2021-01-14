package com.example.miproyectohaikyuu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.miproyectohaikyuu.databinding.FragmentPersonajesBinding;
import com.example.miproyectohaikyuu.viewmodel.PersonajesViewModel;


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

        personajesViewModel.seleccionado().observe(getViewLifecycleOwner(), personaje -> {
            Glide.with(PersonajesFragment.this).load(personaje.foto).into(binding.foto);
            Glide.with(PersonajesFragment.this).load(personaje.escudo).into(binding.escudo);
            binding.nombre.setText(personaje.nombre);
            binding.posicion.setText(personaje.posicion);
            binding.equipo.setText(personaje.nombreEquipo);
            binding.altura.setText(personaje.altura);
            binding.bloqueo.setText(personaje.bloqueo);
            binding.remate.setText(personaje.remate);
            binding.recepcion.setText(personaje.recepcion);
            binding.saque.setText(personaje.saque);
            binding.colocacion.setText(personaje.colocacion);
        });
    }
}


