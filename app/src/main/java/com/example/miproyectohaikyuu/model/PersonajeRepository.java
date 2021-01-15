package com.example.miproyectohaikyuu.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PersonajeRepository {

    private final AppBaseDeDatos.PersonajeDao personajeDao;

    public PersonajeRepository(Application application) {

        personajeDao = AppBaseDeDatos.getInstance(application).obtenerPersonajeDao();
    }

    public LiveData<List<PersonajeConEquipo>> obtener(){
        return personajeDao.obtener();
    }

    public LiveData<List<Equipo>> obtenerEquipo(){
        return personajeDao.obtenerEquipo();
    }

}
