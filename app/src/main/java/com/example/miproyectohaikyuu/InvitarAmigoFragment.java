package com.example.miproyectohaikyuu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.miproyectohaikyuu.databinding.FragmentInvitarAmigoBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.miproyectohaikyuu.R.id.action_invitarAmigoFragment_to_opcionesAmigoFragment;


public class InvitarAmigoFragment extends Fragment {

    private FragmentInvitarAmigoBinding binding;
    private NavController navController;

    List<String> listaAmigos;
    HashMap<String, List<String>> listItem;
    MainAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentInvitarAmigoBinding.inflate(inflater, container, false)).getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listaAmigos = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new MainAdapter(requireContext(),listaAmigos,listItem);
        binding.listaamigos.setAdapter(adapter);
        initListData();

        navController = Navigation.findNavController(view);
        binding.irAtras.setOnClickListener(v -> navController.popBackStack());
        binding.listaamigos.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {


            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                navController.navigate(action_invitarAmigoFragment_to_opcionesAmigoFragment);
                return true;

            }
        });

    }




    private void initListData() {
        listaAmigos.add(getString(R.string.conectados));
        listaAmigos.add(getString(R.string.desconectados));

        String[] array;

        List<String> list = new ArrayList<>();
        array = getResources().getStringArray(R.array.conectados);
        for (String item : array){
            list.add(item);
        }

        List<String> list2 = new ArrayList<>();
        array = getResources().getStringArray(R.array.desconectados);
        for (String item : array){
            list2.add(item);
        }

        listItem.put(listaAmigos.get(0),list);
        listItem.put(listaAmigos.get(1),list2);
        adapter.notifyDataSetChanged();

    }


}