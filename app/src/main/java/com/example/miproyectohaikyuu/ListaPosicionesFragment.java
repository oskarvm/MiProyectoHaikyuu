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
import com.example.miproyectohaikyuu.databinding.FragmentListaEquiposBinding;
import com.example.miproyectohaikyuu.databinding.FragmentListaPosicionesBinding;
import com.example.miproyectohaikyuu.databinding.FragmentPersonajesPorPosicionBinding;
import com.example.miproyectohaikyuu.databinding.ViewholderListaEquiposBinding;
import com.example.miproyectohaikyuu.databinding.ViewholderListaPosicionesBinding;
import com.example.miproyectohaikyuu.databinding.ViewholderPersonajePorPosicionBinding;
import com.example.miproyectohaikyuu.model.Equipo;
import com.example.miproyectohaikyuu.model.PersonajeConEquipo;
import com.example.miproyectohaikyuu.model.Posicion;
import com.example.miproyectohaikyuu.viewmodel.PersonajesViewModel;

import java.util.List;

public class ListaPosicionesFragment extends Fragment {

    private FragmentListaPosicionesBinding binding;
    PersonajesViewModel personajesViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentListaPosicionesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        personajesViewModel  = new ViewModelProvider(requireActivity()).get(PersonajesViewModel.class);
        //navController = Navigation.findNavController(view);

        PersonajesAdapter personajesAdapter;
        personajesAdapter = new PersonajesAdapter();

        binding.recyclerListaPosiciones.setAdapter(personajesAdapter);
        binding.recyclerListaPosiciones.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        obtenerPosicion().observe(getViewLifecycleOwner(), posiciones -> personajesAdapter.establecerLista(posiciones));
    }

    LiveData<List<Posicion>> obtenerPosicion(){
        return personajesViewModel.obtenerPosicion();
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
                personajesViewModel.seleccionarPosicion(posicion);
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