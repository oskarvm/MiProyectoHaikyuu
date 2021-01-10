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
/**/

import com.example.miproyectohaikyuu.databinding.FragmentListaJugadoresEquiposBinding;


public class ListaJugadoresEquipos extends Fragment {

    private FragmentListaJugadoresEquiposBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentListaJugadoresEquiposBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        navController = Navigation.findNavController(view);

        binding.irKarasuno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_listaEquipoKarasunoFragment);
            }
        });

        binding.irNekoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_listaEquipoNekomaFragment);
            }
        });

        binding.irKamomedai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_listaEquipoKamomedaiFragment);
            }
        });

        binding.irFukorodani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_listaEquipoFukorodaniFragment);
            }
        });

        binding.irDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_listaEquipoDateFragment);
            }
        });

        binding.irAobajosai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_listaEquipoAobajosaiFragment);
            }
        });

        binding.irShiratorizawa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_listaEquipoShiratorizawaFragment);
            }
        });

        binding.irInarizaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_listaEquipoInarizakiFragment);
            }
        });

    }
}