package com.example.miproyectohaikyuu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.miproyectohaikyuu.databinding.FragmentListaEquiposBinding;
import com.example.miproyectohaikyuu.databinding.FragmentListaPosicionesBinding;
import com.example.miproyectohaikyuu.databinding.FragmentListaEquiposYPosicionesBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class ListaEquiposYPosicionesFragment extends Fragment {
    private FragmentListaEquiposYPosicionesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentListaEquiposYPosicionesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position) {
                    case 0: default:
                        return new ListaEquiposFragment();
                    case 1:
                        return new ListaPosicionesFragment();
                }
            }

            @Override
            public int getItemCount() {
                return 2;
            }
        });

        new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: default:
                        tab.setText("EQUIPOS");
                        break;
                    case 1:
                        tab.setText("POSICIONES");
                        break;
                }
            }
        }).attach();

    }


}