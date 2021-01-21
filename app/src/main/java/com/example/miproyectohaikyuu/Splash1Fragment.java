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
import com.example.miproyectohaikyuu.databinding.FragmentSplash1Binding;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class Splash1Fragment extends Fragment {

    Executor executor = Executors.newSingleThreadExecutor();

    NavController navController;
    private FragmentSplash1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentSplash1Binding.inflate(inflater, container, false)).getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Glide.with(requireView()).load(R.drawable.splah1).into(binding.splash1);

        navController = Navigation.findNavController(view);

        final MutableLiveData<Boolean> finishedLoading = new MutableLiveData<>();



        finishedLoading.observe(getViewLifecycleOwner(), aBoolean -> navController.navigate(R.id.action_splash1Fragment_to_splashFragment));

        executor.execute(() -> {
            try {
                Thread.sleep(2000);
                finishedLoading.postValue(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}