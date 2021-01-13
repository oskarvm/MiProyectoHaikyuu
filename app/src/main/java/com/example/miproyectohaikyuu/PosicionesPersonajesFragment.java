package com.example.miproyectohaikyuu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miproyectohaikyuu.databinding.FragmentPosicionesPersonajesBinding;
import com.example.miproyectohaikyuu.databinding.ViewholderPosicionesBinding;


public class PosicionesPersonajesFragment extends Fragment {


    FragmentPosicionesPersonajesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentPosicionesPersonajesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EquiposPosicionesViewModel equiposPosicionesViewModel = new ViewModelProvider(this).get(EquiposPosicionesViewModel.class);

        equiposPosicionesViewModel.equipoposicion();
    }

    class PosicionViewHolder extends RecyclerView.ViewHolder{

        ViewholderPosicionesBinding binding;

        public PosicionViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}