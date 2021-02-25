package com.example.miproyectohaikyuu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.miproyectohaikyuu.databinding.FragmentPersonajesBinding;
import com.example.miproyectohaikyuu.viewmodel.HaikyuuViewModel;


public class PersonajesFragment extends Fragment {
    private FragmentPersonajesBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPersonajesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        HaikyuuViewModel haikyuuViewModel = new ViewModelProvider(requireActivity()).get(HaikyuuViewModel.class);

        navController = Navigation.findNavController(view);

        haikyuuViewModel.seleccionado().observe(getViewLifecycleOwner(), personaje -> {
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


        // cuando haces click aqui, guardas en la base de datos que este jugador va en el equipo tal y en tal posicion
        // y eso lo sabes del viewmodel
        binding.elegirJugador.setOnClickListener(v -> {
            navController.navigate(R.id.action_personajesFragment_to_equipoCreado);
        });


        binding.irAtras.setOnClickListener(v -> navController.popBackStack());
    }
}


