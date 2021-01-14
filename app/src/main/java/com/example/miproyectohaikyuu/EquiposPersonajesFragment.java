package com.example.miproyectohaikyuu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.bumptech.glide.Glide;
import com.example.miproyectohaikyuu.databinding.FragmentEquiposPersonajesBinding;
import com.example.miproyectohaikyuu.databinding.ViewholderEquiposBinding;
import com.example.miproyectohaikyuu.databinding.ViewholderPersonajeBinding;
import com.example.miproyectohaikyuu.model.EquipoPosicion;
import com.example.miproyectohaikyuu.model.Personaje;

import java.util.List;

public class EquiposPersonajesFragment extends Fragment {

    private FragmentEquiposPersonajesBinding binding;
    PersonajesViewModel personajesViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentEquiposPersonajesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        personajesViewModel  = new ViewModelProvider(requireActivity()).get(PersonajesViewModel.class);
        navController = Navigation.findNavController(view);

        PersonajesAdapter personajesAdapter;
        personajesAdapter = new PersonajesAdapter();

        binding.recyclerView.setAdapter(personajesAdapter);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        obtenerPersonaje().observe(getViewLifecycleOwner(), new Observer<List<Personaje>>() {
            @Override
            public void onChanged(List<Personaje> personajes) {
                personajesAdapter.establecerLista(personajes);
            }
        });
    }

    LiveData<List<Personaje>> obtenerPersonaje(){
        return personajesViewModel.obtener();
    }


    class PersonajesAdapter extends RecyclerView.Adapter<PersonajesFragment.PersonajeViewHolder>{
        List<Personaje> personajes;

        @NonNull
        @Override
        public PersonajesFragment.PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PersonajesFragment.PersonajeViewHolder(ViewholderPersonajeBinding.inflate(getLayoutInflater(), parent, false));        }

        @Override
        public void onBindViewHolder(@NonNull PersonajesFragment.PersonajeViewHolder holder, int position) {
            Personaje personaje = personajes.get(position);

            holder.binding.nombre.setText(personaje.nombre);
            holder.binding.posicion.setText(personaje.posicion);

            holder.itemView.setOnClickListener(new View.OnClickListener()

                {
                    @Override
                    public void onClick (View v){
                    personajesViewModel.seleccionar(personaje);
                    navController.navigate(R.id.action_global_personajesFragment);
                }

            });

        }

        @Override
        public int getItemCount() {
            return personajes != null ? personajes.size() : 0;
        }

        public void establecerLista(List<Personaje> elementos){
            this.personajes = elementos;
            notifyDataSetChanged();
        }

        /*public Personaje obtenerPersonaje(int posicion){
            return personajes.get(posicion);
        }*/
    }
}