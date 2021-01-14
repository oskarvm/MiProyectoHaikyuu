package com.example.miproyectohaikyuu.model;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.miproyectohaikyuu.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Database(entities = {Usuario.class, Personaje.class, Equipo.class}, version = 5, exportSchema = false)
public abstract class AppBaseDeDatos extends RoomDatabase {

    public abstract AppDao obtenerDao();
    public abstract PersonajeDao obtenerPersonajeDao();
    private static volatile AppBaseDeDatos INSTANCE;
    static Executor executor = Executors.newSingleThreadExecutor();

    public static AppBaseDeDatos getInstance(final Context context){
        if (INSTANCE == null){
            synchronized (AppBaseDeDatos.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppBaseDeDatos.class, "app.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);

//                                    INSTANCE.obtenerPersonajeDao().obtener();

                                    executor.execute(()->{
                                        insertarTodo(INSTANCE.obtenerPersonajeDao());
//                                        INSTANCE.obtenerPersonajeDao().insertar(new Equipo("Preparatoria Karasuno", R.drawable.escudo_karasuno));

                                    });

//

                                }
                            })
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

        @Insert
        void insertar(Equipo equipo);

        @Query("SELECT * FROM Personaje JOIN Equipo ON Personaje.idEquipo = Equipo.idEquipo")
        LiveData<List<PersonajeConEquipo>> obtener();

//        @Query("SELECT * FROM Personaje JOIN Equipo ON Personaje.idEquipo = Equipo.id AND  nombre = :nombre")
//        PersonajeConEquipo getDatos(String nombre);

        @Query("SELECT idEquipo FROM Equipo WHERE nombreEquipo = :nombre")
        int obtenerIdEquipo(String nombre);
    }



    public static void insertarTodo(PersonajeDao personajeDao){


        Log.e("INSERTANDO DOTO", "KJFLKJDSF");

        List<Equipo> equipos = Arrays.asList(
                new Equipo("Preparatoria Karasuno", R.drawable.escudo_karasuno),
                new Equipo("Preparatoria Nekoma", R.drawable.escudo_nekoma)
        );

        HashMap<String, List<Personaje>> personajes = new HashMap<>();

        personajes.put("Preparatoria Karasuno", Arrays.asList(
                new Personaje(R.drawable.jugador_karasuno_hinata, "Shoyo Hinata", "Bloqueador", 0, "164.2", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_kageyama, "Tobio Kageyama", "Colocador", 0, "181.9", "7", "9", "6", "5", "5")
        ));

        personajes.put("Preparatoria Nekoma", Arrays.asList(
                new Personaje(R.drawable.jugador_nekoma_kuroo,  "Tetsurō Kuroo","Bloqueador", 0, "188.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_nekoma_kai, "Nobuyuki Kai","Opuesto", 0, "176.5", "7", "9", "6", "5", "5")
        ));


            for (Equipo equipo : equipos) {
                personajeDao.insertar(equipo);
            }

            for (String nombreEquipo : personajes.keySet()) {
                int idEquipo = personajeDao.obtenerIdEquipo(nombreEquipo);

                for (Personaje personaje : personajes.get(nombreEquipo)) {
                    personaje.idEquipo = idEquipo;

                    personajeDao.insertar(personaje);
                }
            }
    }
}

