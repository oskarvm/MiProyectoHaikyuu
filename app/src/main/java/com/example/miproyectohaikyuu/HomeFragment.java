package com.example.miproyectohaikyuu;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.miproyectohaikyuu.databinding.FragmentHomeBinding;
import com.example.miproyectohaikyuu.viewmodel.PersonajesViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private NavController navController;
    private PersonajesViewModel personajesViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentHomeBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        personajesViewModel = new ViewModelProvider(this).get(PersonajesViewModel.class);

        navController = Navigation.findNavController(view);

//        personajesViewModel.obtener().observe(getViewLifecycleOwner(), personajes -> {
//            Log.e("personajes size ", ""+personajes.size());
//            if(personajes.size() == 0) personajesViewModel.insertarDeTodo();
//        });

        binding.miPerfil.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_equiposPersonajesFragment));
        binding.verJugadores.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_personajesPorPosicionFragment));
        binding.cerrarSesion.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_cerrarSesionFragment));
        binding.misEquipos.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_misEquipos2));
        binding.jugarPartida.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_jugarPartida2));
    }
}