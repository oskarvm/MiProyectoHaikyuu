package com.example.miproyectohaikyuu;

import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;

import com.example.miproyectohaikyuu.databinding.ActivityMainBinding;
import com.example.miproyectohaikyuu.viewmodel.AutenticacionViewModel;
import com.example.miproyectohaikyuu.viewmodel.HaikyuuViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //ExpandableListView expandableListView;
    //List<String> listaAmigos;
    //HashMap<String, List<String>> listItem;
   // MainAdapter adapter;

    ActivityMainBinding binding;
    AutenticacionViewModel autenticacionViewModel;
    private HaikyuuViewModel haikyuuViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        //expandableListView = findViewById(R.id.listaamigos);
      //  listaAmigos = new ArrayList<>();
    //    listItem = new HashMap<>();
  //      adapter = new MainAdapter(this,listaAmigos,listItem);
//        expandableListView.setAdapter(adapter);
        //initListData();

        autenticacionViewModel = new ViewModelProvider(this).get(AutenticacionViewModel.class);

        haikyuuViewModel = new ViewModelProvider(this).get(HaikyuuViewModel.class);


        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

                Log.e("Navegando hacia: ", (String) destination.getLabel());

                if (destination.getId() == R.id.iniciarSesionFragment
                        || destination.getId() == R.id.registroFragment
                        || destination.getId() == R.id.splashFragment) {
                } else {
                }
            }
        });
    }

    /*private void initListData() {
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

    }*/
}