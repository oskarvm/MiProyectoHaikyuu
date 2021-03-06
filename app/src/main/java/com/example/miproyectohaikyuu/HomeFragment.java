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

import com.example.miproyectohaikyuu.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentHomeBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.irMiPerfil.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_perfilFragment));
        binding.irMisEquipos.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_menuMisEquiposFragment));
        binding.irJugarPartida.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_menuJugarPartidaFragment));
        binding.cerrarSesion.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_cerrarSesionFragment));
    }
}