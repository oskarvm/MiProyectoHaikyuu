package com.example.miproyectohaikyuu.model;

import android.content.Context;

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

@Database(entities = {Usuario.class, Personaje.class, Equipo.class, Posicion.class}, version = 11, exportSchema = false)
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
        void insertarEquipo(Equipo equipo);

        @Insert
        void insertarPosicion(Posicion posicion);

        @Query("SELECT * FROM Personaje JOIN Equipo ON Personaje.idEquipo = Equipo.idEquipo WHERE Equipo.idEquipo = :idEquipo")
        LiveData<List<PersonajeConEquipo>> obtenerPersonajesPorEquipo(int idEquipo);

        @Query("SELECT * FROM Personaje JOIN Equipo ON Personaje.idEquipo = Equipo.idEquipo WHERE Personaje.posicion = :posicion")
        LiveData<List<PersonajeConEquipo>> obtenerPersonajesPorPosicion(String posicion);

        @Query("SELECT DISTINCT Equipo.idEquipo, Equipo.nombreEquipo, Equipo.escudo FROM Equipo JOIN Personaje ON Equipo.idEquipo = Personaje.idEquipo")
        LiveData<List<Equipo>> obtenerEquipo();

        @Query("SELECT DISTINCT * FROM Posicion")
        LiveData<List<Posicion>> obtenerPosicion();


        @Query("SELECT  idEquipo FROM Equipo WHERE nombreEquipo = :nombre")
        int obtenerIdEquipo(String nombre);
    }

    public static void insertarTodo(PersonajeDao personajeDao){

        List<Posicion> posiciones = Arrays.asList(
                new Posicion("Punta", R.drawable.posicion_punta),
                new Posicion("Colocador", R.drawable.posicion_colocador),
                new Posicion("Bloqueador", R.drawable.posicion_bloqueador),
                new Posicion("Opuesto", R.drawable.posicion_opuesto),
                new Posicion("Libero", R.drawable.posicion_libero)
        );

        List<Equipo> equipos = Arrays.asList(
                new Equipo("Preparatoria Karasuno", R.drawable.escudo_karasuno),
                new Equipo("Preparatoria Nekoma", R.drawable.escudo_nekoma),
                new Equipo("Preparatoria Kamomedai", R.drawable.escudo_kamomedai),
                new Equipo("Academia Fukurōdani", R.drawable.escudo_fukorodani),
                new Equipo("Preparatoria Tecnica de Date", R.drawable.escudo_date),
                new Equipo("Preparatoria Aoba Josai", R.drawable.escudo_aobajosai),
                new Equipo("Academia Shiratorizawa", R.drawable.escudo_shiratorizawa),
                new Equipo("Preparatoria Inarizaki", R.drawable.escudo_inarizaki)
        );

        HashMap<String, List<Personaje>> personajes = new HashMap<>();

        personajes.put("Preparatoria Karasuno", Arrays.asList(
                new Personaje(R.drawable.jugador_karasuno_hinata, "Shoyo Hinata", "Bloqueador", 0, "164.2", "7", "9", "6", "5", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_karasuno_kageyama, "Tobio Kageyama", "Colocador", 0, "181.9", "7", "8", "7", "8", "10",R.drawable.posicion_colocador),
                new Personaje(R.drawable.jugador_karasuno_tanaka,  "Ryu Tanaka", "Punta",0, "178.2", "6", "9", "6", "7", "5",R.drawable.posicion_punta),
                new Personaje(R.drawable.jugador_karasuno_nishinoya,  "Yū Nishinoya","Libero", 0, "160.5", "5", "5", "10", "5", "8",R.drawable.posicion_libero),
                new Personaje(R.drawable.jugador_karasuno_tsuki,  "Kei Tsukishima","Bloqueador", 0, "190.1", "9", "7", "4", "5", "6",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_karasuno_asahi,  "Azumane Asahi","Punta", 0, "186.4", "8", "8", "7", "7", "5",R.drawable.posicion_punta),
                new Personaje(R.drawable.jugador_karasuno_daichi, "Sawamura Daichi","Opuesto", 0, "176.7", "7", "7", "9", "6", "5",R.drawable.posicion_opuesto),
                new Personaje(R.drawable.jugador_karasuno_sugawara,"Kōshi Sugawara","Colocador", 0, "174.6", "6", "6", "7", "7", "8",R.drawable.posicion_colocador),
                new Personaje(R.drawable.jugador_karasuno_yamaguchi, "Tadashi Yamaguchi","Bloqueador", 0, "180.0", "7", "6", "5", "8", "5",R.drawable.posicion_bloqueador)
        ));

        personajes.put("Preparatoria Nekoma", Arrays.asList(
                new Personaje(R.drawable.jugador_nekoma_kuroo,  "Tetsurō Kuroo","Bloqueador", 0, "188.0", "9", "8", "6", "6", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_nekoma_kai, "Nobuyuki Kai","Opuesto", 0, "176.5", "7", "8", "7", "6", "5",R.drawable.posicion_opuesto),
                new Personaje(R.drawable.jugador_nekoma_yaku,"Morisuke Yaku","Libero", 0, "166.0", "5", "5", "10", "5", "6",R.drawable.posicion_libero),
                new Personaje(R.drawable.jugador_nekoma_yamamoto,"Taketora Yamamoto","Punta", 0, "178.0", "7", "8", "7", "8", "5",R.drawable.posicion_punta),
                new Personaje(R.drawable.jugador_nekoma_kenma,"Kozume Kenma","Colocador", 0, "170.0", "6", "5", "6", "6", "9",R.drawable.posicion_colocador),
                new Personaje(R.drawable.jugador_nekoma_fukunaga,"Shōhei Fukugana","Punta", 0, "179.0", "8", "8", "7", "6", "5",R.drawable.posicion_punta),
                new Personaje(R.drawable.jugador_nekoma_lev,"Lev Haiba","Bloqueador", 0, "196.0", "9", "9", "5", "5", "5",R.drawable.posicion_bloqueador)
        ));

        personajes.put("Preparatoria Kamomedai", Arrays.asList(
                new Personaje(R.drawable.jugador_kamomedai_suwa,"Aichiki Suwa","Colocador", 0, "177.8", "7", "6", "7", "7", "9",R.drawable.posicion_colocador),
                new Personaje(R.drawable.jugador_kamomedai_nozawa,"Izuru Nozawa","Punta", 0, "181.8", "7", "8", "7", "7", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_kamomedai_hoshiumi,"Kōrai Hoshiumi","Punta", 0, "169.2", "8", "10", "9", "8", "7",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_kamomedai_hirugami,"Sachirō Hirugami","Bloqueador", 0, "190.4", "7", "9", "6", "5", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_kamomedai_hakuba,"Gao Hakuba","Opuesto", 0, "203.3", "10", "8", "6", "6", "5",R.drawable.posicion_opuesto),
                new Personaje(R.drawable.jugador_kamomedai_bessho,"Kazuyoshi Bessho","Bloqueador", 0, "186.7", "8", "7", "7", "6", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_kamomedai_kanbayashi,"Keiichirō Kanbayashi","Libero", 0, "173.2", "5", "5", "9", "5", "6",R.drawable.posicion_libero)
        ));

        personajes.put("Academia Fukurōdani", Arrays.asList(
                new Personaje(R.drawable.jugador_fukorodani_washio,"Tatsuki Washio","Bloqueador", 0, "188.0", "9", "7", "7", "6", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_fukorodani_sarukui,"Yamato Sarukui","Punta", 0, "181.5", "7", "7", "7", "7", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_fukorodani_bokuto,"Kōtarō Bokuto","Punta", 0, "186.0", "8", "10", "8", "9", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_fukorodani_akaashi,"Keiji Akaashi","Colocador", 0, "183.0", "8", "7", "6", "8", "9",R.drawable.posicion_colocador),
                new Personaje(R.drawable.jugador_fukorodani_konoha,"Akinori Konoha","Opuesto", 0, "178.8", "8", "8", "7", "6", "5",R.drawable.posicion_opuesto),
                new Personaje(R.drawable.jugador_fukorodani_komi,"Haruki Komi","Libero", 0, "166.0", "5", "5", "8", "5", "6",R.drawable.posicion_libero),
                new Personaje(R.drawable.jugador_fukorodani_onaga,"Wataru Onaga","Bloqueador", 0, "193.0", "8", "7", "6", "6", "5",R.drawable.posicion_bloqueador)
        ));

        personajes.put("Preparatoria Tecnica de Date", Arrays.asList(
                new Personaje(R.drawable.jugador_date_aone,"Takanobu Aone", "Bloqueador", 0, "192.0", "9", "7", "6", "6", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_date_futakuchi,"Kenji Futakuchi","Punta", 0, "184.2", "8", "8", "7", "7", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_date_obara,"Yukata Obara","Punta", 0, "187.0", "7", "7", "7", "6", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_date_kogagenawa,"Kanji Koganegawa","Colocador", 0, "193.0", "8", "6", "5", "5", "8",R.drawable.posicion_colocador),
                new Personaje(R.drawable.jugador_date_onagawa,"Tarō Onagawa","Opuesto", 0, "176.0", "7", "7", "6", "7", "5",R.drawable.posicion_opuesto),
                new Personaje(R.drawable.jugador_date_fukiage,"Jingo Fukiage","Bloqueador", 0, "186.3", "7", "6", "6", "6", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_date_sakumani, "Kōsuke Sakunami","Libero", 0, "166.0", "5", "5", "8", "5", "5",R.drawable.posicion_libero)
        ));

        personajes.put("Preparatoria Aoba Josai", Arrays.asList(
                new Personaje(R.drawable.jugador_aobajosai_oikawa,"Tōru Oikawa","Colocador", 0, "184.3", "8", "7", "7", "9", "10",R.drawable.posicion_colocador),
                new Personaje(R.drawable.jugador_aobajosai_matsukawa,"Issei Matsukawa","Bloqueador", 0, "187.9", "8", "7", "6", "6", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_aobajosai_iwaizumi,"Hajime Iwaizumi","Punta", 0, "179.3", "7", "9", "9", "7", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_aobajosai_watari,"Shinji Watari","Libero", 0, "171.2", "5", "5", "8", "5", "7",R.drawable.posicion_libero),
                new Personaje(R.drawable.jugador_aobajosai_kindaichi, "Yūtarō Kindaichi","Bloqueador", 0, "190.0", "8", "7", "6", "6", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_aobajosai_kumini,"Akira Kumini","Opuesto", 0, "183.0", "7", "9", "6", "5", "5",R.drawable.posicion_opuesto),
                new Personaje(R.drawable.jugador_aobajosai_kentaro,"Kentarō Kyōtanii","Punta", 0, "178.8", "7", "8", "7", "8", "5",R.drawable.posicion_bloqueador)
        ));

        personajes.put("Academia Shiratorizawa", Arrays.asList(
                new Personaje(R.drawable.jugador_shiratorizawa_ushijima,"Wakathosi Ushijima","Opuesto", 0, "189.5", "8", "9", "7", "9", "5",R.drawable.posicion_opuesto),
                new Personaje(R.drawable.jugador_shiratorizawa_tendo, "Satori Tendō","Bloqueador", 0, "187.7", "9", "8", "7", "6", "6",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_shiratorizawa_shibaru, "Kenjirō Shibaru","Colocador", 0, "174.8", "6", "7", "7", "7", "8",R.drawable.posicion_colocador),
                new Personaje(R.drawable.jugador_shiratorizawa_reon,"Reon Ōhira","Punta", 0, "182.7", "7", "8", "7", "7", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_shiratorizawa_goshiki,"Tsutomu Goshiki","Punta", 0, "181.5", "7", "8", "7", "7", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_shiratorizawa_yamagata,"Hayato Yamagata","Libero", 0, "174.0", "5", "5", "8", "5", "5",R.drawable.posicion_libero),
                new Personaje(R.drawable.jugador_shiratorizawa_kawanishi,"Taichi Kawanishi","Bloqueador", 0, "188.3", "7", "7", "6", "5", "5",R.drawable.posicion_bloqueador)
        ));

        personajes.put("Preparatoria Inarizaki", Arrays.asList(
                new Personaje(R.drawable.jugador_inarizaki_kita, "Shinsuke Kita","Punta", 0, "175.2", "7", "7", "8", "7", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_inarizaki_aran,"Aran Ojiro","Punta", 0, "184.7", "7", "9", "7", "8", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_inarizaki_osamu,"Osamu Miya","Opuesto", 0, "183.8", "7", "8", "7", "7", "7",R.drawable.posicion_opuesto),
                new Personaje(R.drawable.jugador_inarizaki_atsumu,"Atsumu Miya","Colocador", 0, "183.6", "7", "7", "6", "9", "9",R.drawable.posicion_colocador),
                new Personaje(R.drawable.jugador_inarizaki_suna,"Rintarō Suna","Bloqueador", 0, "185.7", "8", "8", "6", "6", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_inarizaki_omimi,"Ren Ōmimi","Bloqueador", 0, "191.5", "8", "7", "6", "6", "5",R.drawable.posicion_bloqueador),
                new Personaje(R.drawable.jugador_inarizaki_akagi,"Michinari Akagi","Libero", 0, "174.2", "5", "5", "8", "5", "6",R.drawable.posicion_libero)
        ));

        for (Posicion posicion : posiciones) {
            personajeDao.insertarPosicion(posicion);
        }

        for (Equipo equipo : equipos) {
                personajeDao.insertarEquipo(equipo);
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

