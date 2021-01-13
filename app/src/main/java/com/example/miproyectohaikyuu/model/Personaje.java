package com.example.miproyectohaikyuu.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Personaje {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public int foto;
    public int escudo;
    public String nombre;
    public String posicion;
    public String equipo;
    public String altura;
    public String bloqueo;
    public String remate;
    public String recepcion;
    public String saque;
    public String colocacion;

    public Personaje(int foto, int escudo, String nombre, String posicion, String equipo, String altura, String bloqueo, String remate, String recepcion, String saque, String colocacion) {
        this.foto = foto;
        this.escudo = escudo;
        this.posicion = posicion;
        this.nombre = nombre;
        this.equipo = equipo;
        this.altura = altura;
        this.bloqueo = bloqueo;
        this.remate = remate;
        this.recepcion = recepcion;
        this.saque = saque;
        this.colocacion = colocacion;
    }
}
