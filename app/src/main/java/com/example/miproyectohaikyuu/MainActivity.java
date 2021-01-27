package com.example.miproyectohaikyuu;

import android.os.Bundle;
import android.util.Log;

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

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    AutenticacionViewModel autenticacionViewModel;
    private HaikyuuViewModel haikyuuViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

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
}