package com.example.miproyectohaikyuu.model;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

@Database(entities = {Usuario.class, Personaje.class}, version = 2, exportSchema = false)
public abstract class AppBaseDeDatos extends RoomDatabase {

    public abstract AppDao obtenerDao();
    public abstract PersonajeDao obtenerPersonajeDao();
    private static volatile AppBaseDeDatos INSTANCE;

    public static AppBaseDeDatos getInstance(final Context context){
        if (INSTANCE == null){
            synchronized (AppBaseDeDatos.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppBaseDeDatos.class, "app.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    @Dao
    public interface AppDao {
        @Insert
        void insertarUsuario(Usuario usuario);

        @Query("SELECT * FROM Usuario WHERE username = :nombre AND password = :contrasenya")
        Usuario autenticar(String nombre, String contrasenya);

        @Query("SELECT * FROM Usuario WHERE username = :nombre")
        Usuario comprobarNombreDisponible(String nombre);
    }

    @Dao
    public interface PersonajeDao {
        @Insert
        void insertar(Personaje personaje);

        @Query("SELECT * FROM Personaje")
        LiveData<List<Personaje>> obtener();
    }
}

