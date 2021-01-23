package com.example.miproyectohaikyuu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.miproyectohaikyuu.databinding.FragmentSplashBinding;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class SplashFragment extends Fragment {

    Executor executor = Executors.newSingleThreadExecutor();

    NavController navController;
    private FragmentSplashBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentSplashBinding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.progressBar1.animateProgress(5200, 0, 100);

        Glide.with(requireView()).load(R.drawable.cuervobueno).into(binding.carga1);

        navController = Navigation.findNavController(view);

        final MutableLiveData<Boolean> finishedLoading = new MutableLiveData<>();



        finishedLoading.observe(getViewLifecycleOwner(), aBoolean -> navController.navigate(R.id.action_splashFragment_to_iniciarSesionFragment));

        executor.execute(() -> {
            try {
                Thread.sleep(5000);
                finishedLoading.postValue(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}