package com.example.miproyectohaikyuu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class EquiposPosicionesViewModel extends AndroidViewModel {
    EquipoPosicionRepository equipoPosicionRepository;

    public EquiposPosicionesViewModel(@NonNull Application application) {
        super(application);

        equipoPosicionRepository = new EquipoPosicionRepository();
    }

    LiveData<List<EquipoPosicion>> equipoposicion(){
        return equipoPosicionRepository.euipoposicion();
    }
}
