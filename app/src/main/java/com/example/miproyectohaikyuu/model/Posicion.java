package com.example.miproyectohaikyuu.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Posicion {
    @PrimaryKey(autoGenerate = true)
    public int idPosicion;

    public String nombrePosicion;
    public int fotoPosicion;

    public Posicion(String nombrePosicion, int fotoPosicion) {
        this.nombrePosicion = nombrePosicion;
        this.fotoPosicion = fotoPosicion;
    }
}
