package com.example.miproyectohaikyuu.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.miproyectohaikyuu.model.Equipo;
import com.example.miproyectohaikyuu.model.PersonajeConEquipo;
import com.example.miproyectohaikyuu.model.HaikyuuRepository;
import com.example.miproyectohaikyuu.model.Posicion;

import java.util.List;

public class HaikyuuViewModel extends AndroidViewModel {
    HaikyuuRepository haikyuuRepository;

    public  MutableLiveData<PersonajeConEquipo> personajeSeleccionado = new MutableLiveData<>();

    public  MutableLiveData<Equipo> equipoSeleccionado = new MutableLiveData<>();

    public  MutableLiveData<Posicion> posicionSeleccionado = new MutableLiveData<>();

    public HaikyuuViewModel(@NonNull Application application) {
        super(application);

        haikyuuRepository = new HaikyuuRepository(application);
    }

    public LiveData<List<PersonajeConEquipo>> obtenerPersonajesPorEquipo(Equipo equipo){
        return haikyuuRepository.obtenerPersonajesPorEquipo(equipo);
    }

    public LiveData<List<PersonajeConEquipo>> obtenerPersonajesPorPosicion(Posicion posicion){
        return haikyuuRepository.obtenerPersonajesPorPosicion(posicion);
    }

    public LiveData<List<Equipo>> obtenerEquipo(){
        return haikyuuRepository.obtenerEquipo();
    }

    public LiveData<List<Posicion>> obtenerPosicion(){
        return haikyuuRepository.obtenerPosicion();
    }

    public HaikyuuRepository getHaikyuuRepository() {
        return haikyuuRepository;
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

    public MutableLiveData<Posicion> posicionSeleccionado(){
        return posicionSeleccionado;
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
