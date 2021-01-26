package com.example.miproyectohaikyuu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.miproyectohaikyuu.databinding.FragmentPartidaGifBinding;
import com.example.miproyectohaikyuu.viewmodel.AutenticacionViewModel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PartidaGifFragment extends Fragment {

    private AutenticacionViewModel autenticacionViewModel;
    private NavController navController;
    private FragmentPartidaGifBinding binding;

    Executor executor = Executors.newSingleThreadExecutor();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPartidaGifBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        autenticacionViewModel = new ViewModelProvider(requireActivity()).get(AutenticacionViewModel.class);
        navController = Navigation.findNavController(view);

        Glide.with(requireView()).load(R.drawable.gif2).into(binding.gif);

        final MutableLiveData<Boolean> finishedLoading = new MutableLiveData<>();

        finishedLoading.observe(getViewLifecycleOwner(), aBoolean -> navController.navigate(R.id.action_partidaGifFragment_to_partidaFinalizadaFragment));

        executor.execute(() -> {
            try {
                Thread.sleep(1500);
                finishedLoading.postValue(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}