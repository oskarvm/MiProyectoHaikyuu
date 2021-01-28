package com.example.miproyectohaikyuu;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.miproyectohaikyuu.databinding.FragmentCrearEquipoBinding;


public class crearEquipoFragment extends Fragment {

    private FragmentCrearEquipoBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentCrearEquipoBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.insertar1.setOnClickListener(v -> navController.navigate(R.id.action_crearEquipo_to_listaEquiposYPosicionesFragment));
        binding.insertar2.setOnClickListener(v -> navController.navigate(R.id.action_crearEquipo_to_listaEquiposYPosicionesFragment));
        binding.insertar3.setOnClickListener(v -> navController.navigate(R.id.action_crearEquipo_to_listaEquiposYPosicionesFragment));
        binding.insertar4.setOnClickListener(v -> navController.navigate(R.id.action_crearEquipo_to_listaEquiposYPosicionesFragment));
        binding.insertar5.setOnClickListener(v -> navController.navigate(R.id.action_crearEquipo_to_listaEquiposYPosicionesFragment));
        binding.insertar6.setOnClickListener(v -> navController.navigate(R.id.action_crearEquipo_to_listaEquiposYPosicionesFragment));
        binding.insertar7.setOnClickListener(v -> navController.navigate(R.id.action_crearEquipo_to_listaEquiposYPosicionesFragment));

        binding.irAtras.setOnClickListener(v  -> navController.navigate(R.id.action_crearEquipo_to_menuMisEquiposFragment));
    }
}