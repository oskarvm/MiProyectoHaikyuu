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

import com.example.miproyectohaikyuu.databinding.FragmentMenuListasBinding;


public class MenuListasFragment extends Fragment {

    private FragmentMenuListasBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMenuListasBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.porEpuipos.setOnClickListener(v -> navController.navigate(R.id.action_menuListasFragment_to_listaEquiposFragment));
        binding.porPosiciones.setOnClickListener(v -> navController.navigate(R.id.action_menuListasFragment_to_listaPosicionesFragment));


        binding.irAtras.setOnClickListener(v -> navController.popBackStack());
    }
}