package com.example.miproyectohaikyuu;

public class Personaje {
    int foto;
    String nombre;
    String posicion;
    String equipo;
    String altura;
    String bloqueo;
    String remate;
    String recepcion;
    String saque;
    String colocacion;

    public Personaje(int foto, String nombre, String posicion, String equipo, String altura, String bloqueo, String remate, String recepcion, String saque, String colocacion) {
        this.foto = foto;
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
