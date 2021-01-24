package com.example.miproyectohaikyuu.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.miproyectohaikyuu.model.Equipo;
import com.example.miproyectohaikyuu.model.Personaje;
import com.example.miproyectohaikyuu.model.PersonajeConEquipo;
import com.example.miproyectohaikyuu.model.PersonajeRepository;
import com.example.miproyectohaikyuu.model.Posicion;

import java.util.List;

public class PersonajesViewModel extends AutenticacionViewModel {
    PersonajeRepository personajeRepository;

    public  MutableLiveData<PersonajeConEquipo> personajeSeleccionado = new MutableLiveData<>();

    public  MutableLiveData<Equipo> equipoSeleccionado = new MutableLiveData<>();

    public  MutableLiveData<Posicion> posicionSeleccionado = new MutableLiveData<>();

    public PersonajesViewModel(@NonNull Application application) {
        super(application);

        personajeRepository = new PersonajeRepository(application);
    }

    public LiveData<List<PersonajeConEquipo>> obtener(){
        return personajeRepository.obtener();
    }

    public LiveData<List<Equipo>> obtenerEquipo(){
        return personajeRepository.obtenerEquipo();
    }

    public LiveData<List<Posicion>> obtenerPosicion(){
        return personajeRepository.obtenerPosicion();
    }

    public PersonajeRepository getPersonajeRepository() {
        return personajeRepository;
    }

    public void seleccionar(PersonajeConEquipo personaje){
        personajeSeleccionado.setValue(personaje);
    }

    public MutableLiveData<PersonajeConEquipo> seleccionado(){
        return personajeSeleccionado;
    }

    public MutableLiveData<Equipo> equipoSeleccionado(){
        return equipoSeleccionado;
    }

    public void seleccionarEquipo(Equipo equipo){
        equipoSeleccionado.setValue(equipo);
    }

    public void seleccionarPosicion(Posicion posicion){
        posicionSeleccionado.setValue(posicion);
    }

   // public void insertarDeTodo(){
//        personajeRepository.insertarTodo();
    //}

    /*public void insertar(Personaje personaje){
        personajeRepository.insertar(personaje);
    }*/

}
