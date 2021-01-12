package com.example.miproyectohaikyuu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PersonajesViewModel extends AutenticacionViewModel {
    PersonajeRepository personajeRepository;

    public PersonajesViewModel(@NonNull Application application) {
        super(application);

        personajeRepository = new PersonajeRepository();
    }

    LiveData<List<Personaje>> personajes() {
        return personajeRepository.personajes();
    }
}
