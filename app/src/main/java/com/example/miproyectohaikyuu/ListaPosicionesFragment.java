package com.example.miproyectohaikyuu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.miproyectohaikyuu.databinding.FragmentListaPosicionesBinding;
import com.example.miproyectohaikyuu.databinding.ViewholderListaPosicionesBinding;
import com.example.miproyectohaikyuu.model.Posicion;
import com.example.miproyectohaikyuu.viewmodel.HaikyuuViewModel;

import java.util.List;

public class ListaPosicionesFragment extends Fragment {

    private FragmentListaPosicionesBinding binding;
    HaikyuuViewModel haikyuuViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentListaPosicionesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        haikyuuViewModel = new ViewModelProvider(requireActivity()).get(HaikyuuViewModel.class);
        //navController = Navigation.findNavController(view);

        PersonajesAdapter personajesAdapter;
        personajesAdapter = new PersonajesAdapter();

        binding.recyclerListaPosiciones.setAdapter(personajesAdapter);
        binding.recyclerListaPosiciones.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        obtenerPosicion().observe(getViewLifecycleOwner(), posiciones -> personajesAdapter.establecerLista(posiciones));
    }

    LiveData<List<Posicion>> obtenerPosicion(){
        return haikyuuViewModel.obtenerPosicion();
    }

    class PersonajesAdapter extends RecyclerView.Adapter<PersonajeViewHolder>{
        List<Posicion> posiciones;

        @NonNull
        @Override
        public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PersonajeViewHolder(ViewholderListaPosicionesBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
            Posicion posicion = posiciones.get(position);

            holder.binding.posicion.setText(posicion.nombrePosicion);
            Glide.with(ListaPosicionesFragment.this).load(posicion.fotoPosicion).into(holder.binding.posicionfoto);

            holder.itemView.setOnClickListener(v -> {
                navController = Navigation.findNavController(v);
                haikyuuViewModel.seleccionarPosicion(posicion);
                navController.navigate(R.id.action_listaEquiposYPosicionesFragment_to_personajesPorPosicionFragment);
            });
        }

        //Size equipos
        @Override
        public int getItemCount() {
            return posiciones != null ? posiciones.size() : 0;
        }

        public void establecerLista(List<Posicion> posiciones){
            this.posiciones = posiciones;
            notifyDataSetChanged();
        }

    }

    static class PersonajeViewHolder extends RecyclerView.ViewHolder {
        final ViewholderListaPosicionesBinding binding;

        public PersonajeViewHolder(@NonNull ViewholderListaPosicionesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}