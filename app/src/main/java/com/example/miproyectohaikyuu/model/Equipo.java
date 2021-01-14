package com.example.miproyectohaikyuu.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Equipo {
    @PrimaryKey(autoGenerate = true)
    public int idEquipo;

    public String nombreEquipo;
    public int escudo;

    public Equipo(String nombreEquipo, int escudo) {
        this.nombreEquipo = nombreEquipo;
        this.escudo = escudo;
    }
}
