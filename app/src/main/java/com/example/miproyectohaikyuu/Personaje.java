package com.example.miproyectohaikyuu;

public class Personaje {
    int foto;
    String nombre;
    String posicion;
    String equipo;
    float altura;
    int bloqueo;
    int remate;
    int recepcion;
    int saque;
    int colocacion;

    public Personaje(int foto, String nombre, String posicion, String equipo, float altura, int bloqueo, int remate, int recepcion, int saque, int colocacion) {
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
