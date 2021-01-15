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

import com.example.miproyectohaikyuu.databinding.FragmentMenuMisEquiposBinding;
import com.example.miproyectohaikyuu.viewmodel.PersonajesViewModel;

public class MenuMisEquiposFragment extends Fragment {

    private FragmentMenuMisEquiposBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMenuMisEquiposBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.equipo1.setOnClickListener(v -> navController.navigate(R.id.action_menuMisEquiposFragment_to_equipoCreado));
        binding.equipo2.setOnClickListener(v -> navController.navigate(R.id.action_menuMisEquiposFragment_to_crearEquipo));
        binding.equipo3.setOnClickListener(v -> navController.navigate(R.id.action_menuMisEquiposFragment_to_equipoCreado));
        binding.irAtras.setOnClickListener(v -> navController.popBackStack());
    }
}