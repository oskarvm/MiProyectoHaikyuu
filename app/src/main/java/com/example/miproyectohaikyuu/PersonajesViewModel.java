package com.example.miproyectohaikyuu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.miproyectohaikyuu.model.Personaje;
import com.example.miproyectohaikyuu.model.PersonajeRepository;

import java.util.List;

public class PersonajesViewModel extends AutenticacionViewModel {
    PersonajeRepository personajeRepository;

    public PersonajesViewModel(@NonNull Application application) {
        super(application);

        personajeRepository = new PersonajeRepository(application);


    }

    public void insertar(int foto, int escudo, String nombre, String posicion, String equipo, String altura, String bloqueo, String remate, String recepcion, String saque, String colocacion){
        personajeRepository.insertar(foto, escudo, nombre, posicion, equipo, altura, bloqueo, remate, recepcion, saque, colocacion);
    }

    LiveData<List<Personaje>> personajes() {
        return personajeRepository.personajes();
    }

    public void insertarDeTodo(){
        personajeRepository.insertarTidi();
    }

    public LiveData<List<Personaje>> obtener(){
        return personajeRepository.obtener();
    }
}
