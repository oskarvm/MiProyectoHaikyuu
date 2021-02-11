package com.example.miproyectohaikyuu.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String username;
    public String password;
    public String nombre;
    public String apellido;
    public String correo;
    public String telefono;
    public String edad;
    public String genero;

    public int j1_1, j1_2, j1_3;

    public Usuario(String username, String password, String nombre, String apellido, String correo, String telefono, String edad, String genero) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;
        this.genero = genero;
    }

    @NonNull
    @Override
    public String toString() {
        return "USER = " + username + " " + password;
    }
}
