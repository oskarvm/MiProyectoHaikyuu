package com.example.miproyectohaikyuu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miproyectohaikyuu.databinding.FragmentPerfilBinding;
import com.example.miproyectohaikyuu.model.Usuario;
import com.example.miproyectohaikyuu.viewmodel.AutenticacionViewModel;


public class PerfilFragment extends Fragment {

    private FragmentPerfilBinding binding;
    private AutenticacionViewModel autenticacionViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPerfilBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        autenticacionViewModel = new ViewModelProvider(requireActivity()).get(AutenticacionViewModel.class);

        autenticacionViewModel.usuarioAutenticado.observe(getViewLifecycleOwner(), new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                binding.username.setText(usuario.username);
                binding.nombre.setText(usuario.nombre);
                binding.apellido.setText(usuario.apellido);
                binding.correo.setText(usuario.correo);
                binding.telefono.setText(usuario.telefono);
                binding.edad.setText(usuario.edad);
                binding.genero.setText(usuario.genero);

            }
        });
    }
}