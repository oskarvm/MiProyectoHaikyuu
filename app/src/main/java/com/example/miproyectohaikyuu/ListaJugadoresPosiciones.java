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


import com.example.miproyectohaikyuu.databinding.FragmentListaJugadoresPosicionesBinding;


public class ListaJugadoresPosiciones extends Fragment {

    private FragmentListaJugadoresPosicionesBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentListaJugadoresPosicionesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.irPunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_listaPosicionPuntaFragment);
            }
        });

        binding.irBloqueador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_listaPosicionBloqueadorFragment);
            }
        });

        binding.irColocador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_listaPosicionColocadorFragment);
            }
        });

        binding.irOpuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_listaPosicionOpuestoFragment);
            }
        });

        binding.irLibero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_listaPosicionLiberoFragment);
            }
        });

    }
}