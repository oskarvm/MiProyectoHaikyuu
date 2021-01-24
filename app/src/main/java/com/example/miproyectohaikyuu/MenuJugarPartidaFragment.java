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

import com.example.miproyectohaikyuu.databinding.FragmentMenuJugarPartidaBinding;

public class MenuJugarPartidaFragment extends Fragment {

    private FragmentMenuJugarPartidaBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMenuJugarPartidaBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.buscarPartida.setOnClickListener(v -> navController.navigate(R.id.action_menuJugarPartidaFragment_to_buscandoPartidaFragment));
        binding.invitarAmigo.setOnClickListener(v -> navController.navigate(R.id.action_menuJugarPartidaFragment_to_invitarAmigoFragment));
        binding.irHistorial.setOnClickListener(v -> navController.navigate(R.id.action_menuJugarPartidaFragment_to_historialPartidasFragment));
        binding.irAtras.setOnClickListener(v -> navController.navigate(R.id.action_menuJugarPartidaFragment_to_homeFragment));
    }
}