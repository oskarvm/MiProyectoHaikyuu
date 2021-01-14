package com.example.miproyectohaikyuu.model;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.miproyectohaikyuu.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PersonajeRepository {

    private final AppBaseDeDatos.PersonajeDao personajeDao;
    public LiveData<List<Personaje>> personajesLiveData;
    Executor executor = Executors.newSingleThreadExecutor();

    public PersonajeRepository(Application application) {

        personajeDao = AppBaseDeDatos.getInstance(application).obtenerPersonajeDao();
    }




    /*
    public void insertarTodo(){
        executor.execute(() -> {
        List<Personaje> personajes = Arrays.asList(
                new Personaje(R.drawable.jugador_karasuno_hinata, R.drawable.escudo_karasuno, "Shoyo Hinata", "Bloqueador","Preparatoria Karasuno", "164.2", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_kageyama, R.drawable.escudo_karasuno, "Tobio Kageyama", "Colocador","Preparatoria Karasuno", "181.9", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_tanaka, R.drawable.escudo_karasuno, "Ryu Tanaka", "Punta","Preparatoria Karasuno", "178.2", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_nishinoya, R.drawable.escudo_karasuno, "Yū Nishinoya","Libero", "Preparatoria Karasuno", "160.5", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_tsuki, R.drawable.escudo_karasuno, "Kei Tsukishima","Bloqueador", "Preparatoria Karasuno", "190.1", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_asahi, R.drawable.escudo_karasuno, "Azumane Asahi","Punta", "Preparatoria Karasuno", "186.4", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_daichi, R.drawable.escudo_karasuno, "Sawamura Daichi","Opuesto", "Preparatoria Karasuno", "176.7", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_sugawara, R.drawable.escudo_karasuno, "Kōshi Sugawara","Colocador", "Preparatoria Karasuno", "174.6", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_yamaguchi, R.drawable.escudo_karasuno, "Tadashi Yamaguchi","Bloqueaddor", "Preparatoria Karasuno", "180.0f", "7", "9", "6", "5", "5"),

                new Personaje(R.drawable.jugador_nekoma_kuroo, R.drawable.escudo_nekoma, "Tetsurō Kuroo","Bloqueador", "Preparatoria Nekoma", "188.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_nekoma_kai, R.drawable.escudo_nekoma,"Nobuyuki Kai","Opuesto", "Preparatoria Nekoma", "176.5", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_nekoma_yaku, R.drawable.escudo_nekoma,"Morisuke Yaku","Libero", "Preparatoria Nekoma", "166.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_nekoma_yamamoto, R.drawable.escudo_nekoma,"Taketora Yamamoto","Punta", "Preparatoria Nekoma", "178.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_nekoma_kenma, R.drawable.escudo_nekoma,"Kozume Kenma","Colocador", "Preparatoria Nekoma", "170.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_nekoma_fukunaga, R.drawable.escudo_nekoma,"Shōhei Fukugana","Punta", "Preparatoria Nekoma", "179.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_nekoma_lev, R.drawable.escudo_nekoma,"Lev Haiba","Bloqueador", "Preparatoria Nekoma", "196.0", "7", "9", "6", "5", "5"),

                new Personaje(R.drawable.jugador_kamomedai_suwa, R.drawable.escudo_kamomedai,"Aichiki Suwa","Colocador", "Preparatoria Kamomedai", "177.8", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_kamomedai_nozawa, R.drawable.escudo_kamomedai,"Izuru Nozawa","Punta", "Preparatoria Kamomedai", "181.8", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_kamomedai_hoshiumi, R.drawable.escudo_kamomedai,"Kōrai Hoshiumi","Puntta", "Preparatoria Kamomedai", "169.2", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_kamomedai_hirugami, R.drawable.escudo_kamomedai,"Sachirō Hirugami","Bloqueador", "Preparatoria Kamomedai", "190.4", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_kamomedai_hakuba, R.drawable.escudo_kamomedai,"Gao Hakuba","Opuesto", "Preparatoria Kamomedai", "203.3", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_kamomedai_bessho, R.drawable.escudo_kamomedai,"Kazuyoshi Bessho","Bloqueador", "Preparatoria Kamomedai", "186.7", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_kamomedai_kanbayashi, R.drawable.escudo_kamomedai,"Keiichirō Kanbayashi","Libero", "Preparatoria Kamomedai", "173.2", "7", "9", "6", "5", "5"),

                new Personaje(R.drawable.jugador_fukorodani_washio, R.drawable.escudo_fukorodani,"Tatsuki Washio","Bloqueador", "Academia Fukorodani", "188.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_fukorodani_sarukui, R.drawable.escudo_fukorodani,"Yamato Sarukui","Punta", "Academia Fukorodani", "181.5", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_fukorodani_bokuto, R.drawable.escudo_fukorodani,"Kōtarō Bokuto","Punta", "Academia Fukorodani", "186.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_fukorodani_akaashi, R.drawable.escudo_fukorodani,"Keiji Akaashi","Colocador", "Academia Fukorodani", "183.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_fukorodani_konoha, R.drawable.escudo_fukorodani,"Akinori Konoha","Opuesto", "Academia Fukorodani", "178.8", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_fukorodani_komi, R.drawable.escudo_fukorodani,"Haruki Komi","Libero", "Academia Fukorodani", "166.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_fukorodani_onaga, R.drawable.escudo_fukorodani,"Wataru Onaga","Bloqueador", "Academia Fukorodani", "193.0", "7", "9", "6", "5", "5"),

                new Personaje(R.drawable.jugador_date_aone, R.drawable.escudo_date,"Takanobu Aone","Bloqueador", "Preparatoria Tecnica de Date", "192.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_date_futakuchi, R.drawable.escudo_date,"Kenji Futakuchi","Punta", "Preparatoria Tecnica de Date", "184.2", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_date_obara, R.drawable.escudo_date,"Yukata Obara","Punta", "Preparatoria Tecnica de Date", "187.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_date_kogagenawa, R.drawable.escudo_date,"Kanji Koganegawa","Colocador", "Preparatoria Tecnica de Date", "193.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_date_onagawa, R.drawable.escudo_date,"Tarō Onagawa","Opuesto", "Preparatoria Tecnica de Date", "176.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_date_fukiage, R.drawable.escudo_date,"Jingo Fukiage","Bloqueador", "Preparatoria Tecnica de Date", "186.3", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_date_sakumani, R.drawable.escudo_date,"Kōsuke Sakunami","Libero", "Preparatoria Tecnica de Date", "166.0", "7", "9", "6", "5", "5"),

                new Personaje(R.drawable.jugador_aobajosai_oikawa, R.drawable.escudo_aobajosai,"Tōru Oikawa","Colocador", "Preparatoria Aoba Josai", "184.3", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_aobajosai_matsukawa, R.drawable.escudo_aobajosai,"Issei Matsukawa","Bloqueador", "Preparatoria Aoba Josai", "187.9", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_aobajosai_iwaizumi, R.drawable.escudo_aobajosai,"Hajime Iwaizumi","Punta", "Preparatoria Aoba Josai", "179.3", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_aobajosai_watari, R.drawable.escudo_aobajosai,"Shinji Watari","Libero", "Preparatoria Aoba Josai", "171.2", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_aobajosai_kindaichi, R.drawable.escudo_aobajosai,"Yūtarō Kindaichi","Bloqueador", "Preparatoria Aoba Josai", "190.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_aobajosai_kumini, R.drawable.escudo_aobajosai,"Akira Kumini","Opuesto", "Preparatoria Aoba Josai", "183.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_aobajosai_kentaro, R.drawable.escudo_aobajosai,"Kentarō Kyōtanii","Punta", "Preparatoria Aoba Josai", "178.8", "7", "9", "6", "5", "5"),

                new Personaje(R.drawable.jugador_shiratorizawa_ushijima, R.drawable.escudo_shiratorizawa,"Wakathosi Ushijima","Opuesto", "Academia Shiratorizawa", "189.5", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_shiratorizawa_tendo, R.drawable.escudo_shiratorizawa, "Satori Tendō","Bloqueador", "Academia Shiratorizawa", "187.7", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_shiratorizawa_shibaru, R.drawable.escudo_shiratorizawa, "Kenjirō Shibaru","Colocador", "Academia Shiratorizawa", "174.8", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_shiratorizawa_reon, R.drawable.escudo_shiratorizawa,"Reon Ōhira","Punta", "Academia Shiratorizawa", "182.7", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_shiratorizawa_goshiki, R.drawable.escudo_shiratorizawa,"Tsutomu Goshiki","Punta", "Academia Shiratorizawa", "181.5", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_shiratorizawa_yamagata, R.drawable.escudo_shiratorizawa,"Hayato Yamagata","Libero", "Academia Shiratorizawa", "174.0", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_shiratorizawa_kawanishi, R.drawable.escudo_shiratorizawa,"Taichi Kawanishi","Bloqueador", "Academia Shiratorizawa", "188.3", "7", "9", "6", "5", "5"),

                new Personaje(R.drawable.jugador_inarizaki_kita, R.drawable.escudo_inarizaki, "Shinsuke Kita","Punta", "Preparatoria Inarizaki", "175.2", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_inarizaki_aran, R.drawable.escudo_inarizaki,"Aran Ojiro","Punta", "Preparatoria Inarizaki", "184.7", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_inarizaki_osamu, R.drawable.escudo_inarizaki,"Osamu Miya","Opuesto", "Preparatoria Inarizaki", "183.8", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_inarizaki_atsumu, R.drawable.escudo_inarizaki,"Atsumu Miya","Colocador", "Preparatoria Inarizaki", "183.6f", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_inarizaki_suna, R.drawable.escudo_inarizaki,"Rintarō Suna","Bloqueador", "Preparatoria Inarizaki", "185.7", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_inarizaki_omimi, R.drawable.escudo_inarizaki,"Ren Ōmimi","Bloqueador", "Preparatoria Inarizaki", "191.5", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_inarizaki_akagi, R.drawable.escudo_inarizaki,"Michinari Akagi","Libero", "Preparatoria Inarizaki", "174.2", "7", "9", "6", "5", "5")
        );


            for(Personaje personaje:personajes){
                personajeDao.insertar(personaje);
            }
        });

    }
*/
    /*public void insertar(Personaje personaje) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                personajeDao.insertar(personaje);
            }
        });
    }*/

    public LiveData<List<PersonajeConEquipo>> obtener(){
        return personajeDao.obtener();
    }

    public AppBaseDeDatos.PersonajeDao getPersonajeDao() {
        return personajeDao;
    }
}
