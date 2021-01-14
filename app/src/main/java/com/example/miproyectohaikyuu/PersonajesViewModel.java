package com.example.miproyectohaikyuu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.miproyectohaikyuu.model.Personaje;
import com.example.miproyectohaikyuu.model.PersonajeRepository;

import java.util.List;

public class PersonajesViewModel extends AutenticacionViewModel {
    PersonajeRepository personajeRepository;

    MutableLiveData<Personaje> personajeSeleccionado = new MutableLiveData<Personaje>();

    public PersonajesViewModel(@NonNull Application application) {
        super(application);

        personajeRepository = new PersonajeRepository(application);


    }


    public LiveData<List<Personaje>> obtener(){
        return personajeRepository.obtener();
    }

    void seleccionar(Personaje personaje){
        personajeSeleccionado.setValue(personaje);
    }

    MutableLiveData<Personaje> seleccionado(){
        return personajeSeleccionado;
    }


    public void insertarDeTodo(){
        personajeRepository.insertarTodo();
    }

    /*public void insertar(Personaje personaje){
        personajeRepository.insertar(personaje);
    }*/

}
