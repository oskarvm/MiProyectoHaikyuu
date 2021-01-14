package com.example.miproyectohaikyuu.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.miproyectohaikyuu.model.EquipoPosicion;
import com.example.miproyectohaikyuu.model.EquipoPosicionRepository;

import java.util.List;

public class EquiposPosicionesViewModel extends AndroidViewModel {
    EquipoPosicionRepository equipoPosicionRepository;

    public EquiposPosicionesViewModel(@NonNull Application application) {
        super(application);

        equipoPosicionRepository = new EquipoPosicionRepository();
    }

    public  LiveData<List<EquipoPosicion>> equipoposicion(){
        return equipoPosicionRepository.equipoposicion();
    }
}