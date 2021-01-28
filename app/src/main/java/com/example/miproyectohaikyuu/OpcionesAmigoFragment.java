package com.example.miproyectohaikyuu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miproyectohaikyuu.databinding.FragmentOpcionesAmigoBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class OpcionesAmigoFragment extends BottomSheetDialogFragment {


    private FragmentOpcionesAmigoBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentOpcionesAmigoBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(requireParentFragment().requireView());

        binding.invitar.setOnClickListener(v -> navController.navigate(R.id.action_opcionesAmigoFragment_to_buscandoPartidaFragment));
        //binding.borrar.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_perfilFragment));


    }
}