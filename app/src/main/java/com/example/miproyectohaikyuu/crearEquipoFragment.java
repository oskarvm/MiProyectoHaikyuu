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
import com.example.miproyectohaikyuu.databinding.FragmentCrearEquipoBinding;
import com.example.miproyectohaikyuu.viewmodel.HaikyuuViewModel;


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

        HaikyuuViewModel haikyuuViewModel = new ViewModelProvider(requireActivity()).get(HaikyuuViewModel.class);

        haikyuuViewModel.seleccionado().observe(getViewLifecycleOwner(), personaje -> {
            if(haikyuuViewModel.seleccionadoTitulares() == 1){
            Glide.with(crearEquipoFragment.this).load(personaje.foto).into(binding.insertar1);}
            else if(haikyuuViewModel.seleccionadoTitulares() == 2){
            Glide.with(crearEquipoFragment.this).load(personaje.foto).into(binding.insertar2);}

        });

        // en el viewmnodelmodel se que equipo estoy creando

        // aqui puedes hacer una consulta de los jugadores de ese equipo, y con un for mostar sus imagenes




        // antes de navegar guardar en el viewmodel la posicion que se ha clicado
        binding.insertar1.setOnClickListener(v -> {
            haikyuuViewModel.seleccionarTitulares(1);
            navController.navigate(R.id.action_crearEquipo_to_listaEquiposYPosicionesFragment);
        });
        binding.insertar2.setOnClickListener(v -> {
            haikyuuViewModel.seleccionarTitulares(2);
            navController.navigate(R.id.action_crearEquipo_to_listaEquiposYPosicionesFragment);
        });
        binding.insertar3.setOnClickListener(v -> {
            haikyuuViewModel.seleccionarTitulares(3);
            navController.navigate(R.id.action_crearEquipo_to_listaEquiposYPosicionesFragment);
        });
        binding.insertar4.setOnClickListener(v -> {
            haikyuuViewModel.seleccionarTitulares(4);
            navController.navigate(R.id.action_crearEquipo_to_listaEquiposYPosicionesFragment);
        });
        binding.insertar5.setOnClickListener(v -> {
            haikyuuViewModel.seleccionarTitulares(5);
            navController.navigate(R.id.action_crearEquipo_to_listaEquiposYPosicionesFragment);
        });
        binding.insertar6.setOnClickListener(v -> {
            haikyuuViewModel.seleccionarTitulares(6);
            navController.navigate(R.id.action_crearEquipo_to_listaEquiposYPosicionesFragment);
        });
        binding.insertar7.setOnClickListener(v -> {
            haikyuuViewModel.seleccionarTitulares(7);
            navController.navigate(R.id.action_crearEquipo_to_listaEquiposYPosicionesFragment);
        });

        binding.irAtras.setOnClickListener(v  -> navController.navigate(R.id.action_crearEquipo_to_menuMisEquiposFragment));
    }
}