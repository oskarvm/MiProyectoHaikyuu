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

import com.example.miproyectohaikyuu.databinding.FragmentListaEquipoKarasunoBinding;

public class ListaEquipoKarasunoFragment extends Fragment {

    private FragmentListaEquipoKarasunoBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentListaEquipoKarasunoBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);


        binding.irHinata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquipoKarasunoFragment_to_jugadorKarasunoHinataFragment);
            }
        });

        binding.irKageyama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquipoKarasunoFragment_to_jugadorKarasunoKageyamaFragment);
            }
        });

        binding.irTanaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquipoKarasunoFragment_to_jugadorKarasunoTanakaFragment);
            }
        });

        binding.irNishinoya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquipoKarasunoFragment_to_jugadorKarasunoNishinoyaFragment);
            }
        });

        binding.irTsuki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquipoKarasunoFragment_to_jugadorKarasunoTsukishimaFragment);
            }
        });

        binding.irAsahi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquipoKarasunoFragment_to_jugadorKarasunoAsahiFragment);
            }
        });

        binding.irSuga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquipoKarasunoFragment_to_jugadorKarasunoSugawaraFragment);
            }
        });

        binding.irYamaguchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_listaEquipoKarasunoFragment_to_jugadorKarasunoYamaguchiFragment);
            }
        });


    }
}