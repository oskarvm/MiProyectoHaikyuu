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


import com.example.miproyectohaikyuu.databinding.FragmentEquipoCreadoBinding;


public class equipoCreadoFragment extends Fragment {

    private FragmentEquipoCreadoBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentEquipoCreadoBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.jugador1.setOnClickListener(v -> navController.navigate(R.id.action_equipoCreado_to_opcionesJugadorFragment));
        binding.jugador2.setOnClickListener(v -> navController.navigate(R.id.action_equipoCreado_to_opcionesJugadorFragment));
        binding.jugador3.setOnClickListener(v -> navController.navigate(R.id.action_equipoCreado_to_opcionesJugadorFragment));
        binding.jugador4.setOnClickListener(v -> navController.navigate(R.id.action_equipoCreado_to_opcionesJugadorFragment));
        binding.jugador5.setOnClickListener(v -> navController.navigate(R.id.action_equipoCreado_to_opcionesJugadorFragment));
        binding.jugador6.setOnClickListener(v -> navController.navigate(R.id.action_equipoCreado_to_opcionesJugadorFragment));
        binding.jugador7.setOnClickListener(v -> navController.navigate(R.id.action_equipoCreado_to_opcionesJugadorFragment));

        binding.irAtras.setOnClickListener(v -> navController.navigate(R.id.action_equipoCreado_to_menuMisEquiposFragment));
    }
}