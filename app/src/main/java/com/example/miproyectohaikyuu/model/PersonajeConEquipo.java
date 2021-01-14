package com.example.miproyectohaikyuu.model;

public class PersonajeConEquipo {
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
    public String nombreEquipo;
    public int escudo;

    public PersonajeConEquipo(int id, int foto, String nombre, String posicion, int idEquipo, String altura, String bloqueo, String remate, String recepcion, String saque, String colocacion, String nombreEquipo, int escudo) {
        this.id = id;
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
        this.nombreEquipo = nombreEquipo;
        this.escudo = escudo;
    }
}
