package com.example.miproyectohaikyuu.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class HaikyuuRepository {

    private final AppBaseDeDatos.PersonajeDao personajeDao;

    public HaikyuuRepository(Application application) {

        personajeDao = AppBaseDeDatos.getInstance(application).obtenerPersonajeDao();
    }

    public LiveData<List<PersonajeConEquipo>> obtenerPersonajesPorEquipo(Equipo equipo){
        return personajeDao.obtenerPersonajesPorEquipo(equipo.idEquipo);
    }

    public LiveData<List<PersonajeConEquipo>> obtenerPersonajesPorPosicion(Posicion posicion){
        return personajeDao.obtenerPersonajesPorPosicion(posicion.nombrePosicion);
    }

    public LiveData<List<Equipo>> obtenerEquipo(){
        return personajeDao.obtenerEquipo();
    }

    public LiveData<List<Posicion>> obtenerPosicion(){
        return personajeDao.obtenerPosicion();
    }

}
