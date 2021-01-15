package com.example.miproyectohaikyuu.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Personaje {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public int foto;
    public String nombre;
    public String posicion;
    public int idEquipo;
    public String altura;
    public String bloqueo;
    public String remate;
    public String recepcion;
    public String saque;
    public String colocacion;
    public int fotoPosicion;

    public Personaje(int foto, String nombre, String posicion, int idEquipo, String altura, String bloqueo, String remate, String recepcion, String saque, String colocacion, int fotoPosicion) {
        this.foto = foto;
        this.nombre = nombre;
        this.posicion = posicion;
        this.idEquipo = idEquipo;
        this.altura = altura;
        this.bloqueo = bloqueo;
        this.remate = remate;
        this.recepcion = recepcion;
        this.saque = saque;
        this.colocacion = colocacion;
        this.fotoPosicion = fotoPosicion;
    }
}
