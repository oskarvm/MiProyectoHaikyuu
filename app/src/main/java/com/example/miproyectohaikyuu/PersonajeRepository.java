package com.example.miproyectohaikyuu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.List;

public class PersonajeRepository {

    LiveData<List<Personaje>> personajesLiveData;

    PersonajeRepository(){
        List<Personaje> personajes = Arrays.asList(
                new Personaje(R.drawable.jugador_karasuno_hinata, "Shoyo Hinata", "Bloqueador","Preparatoria Karasuno", 164.2f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_karasuno_kageyama, "Tobio Kageyama", "Colocador","Preparatoria Karasuno", 181.9f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_karasuno_tanaka, "Ryu Tanaka", "Punta","Preparatoria Karasuno", 178.2f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_karasuno_nishinoya, "Yū Nishinoya","Libero", "Preparatoria Karasuno", 160.5f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_karasuno_tsuki, "Kei Tsukishima","Bloqueador", "Preparatoria Karasuno", 190.1f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_karasuno_asahi, "Azumane Asahi","Punta", "Preparatoria Karasuno", 186.4f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_karasuno_daichi, "Sawamura Daichi","Opuesto", "Preparatoria Karasuno", 176.7f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_karasuno_sugawara, "Kōshi Sugawara","Colocador", "Preparatoria Karasuno", 174.6f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_karasuno_yamaguchi, "Tadashi Yamaguchi","Bloqueaddor", "Preparatoria Karasuno", 180.0f, 7, 9, 6, 5, 5),

                new Personaje(R.drawable.jugador_nekoma_kuroo, "Tetsurō Kuroo","Bloqueador", "Preparatoria Nekoma", 188.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_nekoma_kai, "Nobuyuki Kai","Opuesto", "Preparatoria Nekoma", 176.5f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_nekoma_yaku, "Morisuke Yaku","Libero", "Preparatoria Nekoma", 166.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_nekoma_yamamoto, "Taketora Yamamoto","Punta", "Preparatoria Nekoma", 178.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_nekoma_kenma, "Kozume Kenma","Colocador", "Preparatoria Nekoma", 170.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_nekoma_fukunaga, "Shōhei Fukugana","Punta", "Preparatoria Nekoma", 179.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_nekoma_lev, "Lev Haiba","Bloqueador", "Preparatoria Nekoma", 196.0f, 7, 9, 6, 5, 5),

                new Personaje(R.drawable.jugador_kamomedai_suwa, "Aichiki Suwa","Colocador", "Preparatoria Kamomedai", 177.8f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_kamomedai_nozawa, "Izuru Nozawa","Punta", "Preparatoria Kamomedai", 181.8f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_kamomedai_hoshiumi, "Kōrai Hoshiumi","Puntta", "Preparatoria Kamomedai", 169.2f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_kamomedai_hirugami, "Sachirō Hirugami","Bloqueador", "Preparatoria Kamomedai", 190.4f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_kamomedai_hakuba, "Gao Hakuba","Opuesto", "Preparatoria Kamomedai", 203.3f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_kamomedai_bessho, "Kazuyoshi Bessho","Bloqueador", "Preparatoria Kamomedai", 186.7f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_kamomedai_kanbayashi, "Keiichirō Kanbayashi","Libero", "Preparatoria Kamomedai", 173.2f, 7, 9, 6, 5, 5),

                new Personaje(R.drawable.jugador_fukorodani_washio, "Tatsuki Washio","Bloqueador", "Academia Fukorodani", 188.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_fukorodani_sarukui, "Yamato Sarukui","Punta", "Academia Fukorodani", 181.5f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_fukorodani_bokuto, "Kōtarō Bokuto","Punta", "Academia Fukorodani", 186.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_fukorodani_akaashi, "Keiji Akaashi","Colocador", "Academia Fukorodani", 183.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_fukorodani_konoha, "Akinori Konoha","Opuesto", "Academia Fukorodani", 178.8f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_fukorodani_komi, "Haruki Komi","Libero", "Academia Fukorodani", 166.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_fukorodani_onaga, "Wataru Onaga","Bloqueador", "Academia Fukorodani", 193.0f, 7, 9, 6, 5, 5),

                new Personaje(R.drawable.jugador_date_aone, "Takanobu Aone","Bloqueador", "Preparatoria Tecnica de Date", 192.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_date_futakuchi, "Kenji Futakuchi","Punta", "Preparatoria Tecnica de Date", 184.2f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_date_obara, "Yukata Obara","Punta", "Preparatoria Tecnica de Date", 187.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_date_kogagenawa, "Kanji Koganegawa","Colocador", "Preparatoria Tecnica de Date", 193.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_date_onagawa, "Tarō Onagawa","Opuesto", "Preparatoria Tecnica de Date", 176.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_date_fukiage, "Jingo Fukiage","Bloqueador", "Preparatoria Tecnica de Date", 186.3f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_date_sakumani, "Kōsuke Sakunami","Libero", "Preparatoria Tecnica de Date", 166.0f, 7, 9, 6, 5, 5),

                new Personaje(R.drawable.jugador_aobajosai_oikawa, "Tōru Oikawa","Colocador", "Preparatoria Aoba Josai", 184.3f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_aobajosai_matsukawa, "Issei Matsukawa","Bloqueador", "Preparatoria Aoba Josai", 187.9f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_aobajosai_iwaizumi, "Hajime Iwaizumi","Punta", "Preparatoria Aoba Josai", 179.3f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_aobajosai_watari, "Shinji Watari","Libero", "Preparatoria Aoba Josai", 171.2f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_aobajosai_kindaichi, "Yūtarō Kindaichi","Bloqueador", "Preparatoria Aoba Josai", 190.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_aobajosai_kumini, "Akira Kumini","Opuesto", "Preparatoria Aoba Josai", 183.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_aobajosai_kentaro, "Kentarō Kyōtanii","Punta", "Preparatoria Aoba Josai", 178.8f, 7, 9, 6, 5, 5),

                new Personaje(R.drawable.jugador_shiratorizawa_ushijima, "Wakathosi Ushijima","Opuesto", "Academia Shiratorizawa", 189.5f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_shiratorizawa_tendo, "Satori Tendō","Bloqueador", "Academia Shiratorizawa", 187.7f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_shiratorizawa_shibaru, "Kenjirō Shibaru","Colocador", "Academia Shiratorizawa", 174.8f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_shiratorizawa_reon, "Reon Ōhira","Punta", "Academia Shiratorizawa", 182.7f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_shiratorizawa_goshiki, "Tsutomu Goshiki","Punta", "Academia Shiratorizawa", 181.5f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_shiratorizawa_yamagata, "Hayato Yamagata","Libero", "Academia Shiratorizawa", 174.0f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_shiratorizawa_kawanishi, "Taichi Kawanishi","Bloqueador", "Academia Shiratorizawa", 188.3f, 7, 9, 6, 5, 5),

                new Personaje(R.drawable.jugador_inarizaki_kita, "Shinsuke Kita","Punta", "Preparatoria Inarizaki", 175.2f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_inarizaki_aran, "Aran Ojiro","Punta", "Preparatoria Inarizaki", 184.7f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_inarizaki_osamu, "Osamu Miya","Opuesto", "Preparatoria Inarizaki", 183.8f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_inarizaki_atsumu, "Atsumu Miya","Colocador", "Preparatoria Inarizaki", 183.6f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_inarizaki_suna, "Rintarō Suna","Bloqueador", "Preparatoria Inarizaki", 185.7f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_inarizaki_omimi, "Ren Ōmimi","Bloqueador", "Preparatoria Inarizaki", 191.5f, 7, 9, 6, 5, 5),
                new Personaje(R.drawable.jugador_inarizaki_akagi, "Michinari Akagi","Libero", "Preparatoria Inarizaki", 174.2f, 7, 9, 6, 5, 5)

                );

                personajesLiveData = new MutableLiveData<>(personajes);
    }

    LiveData<List<Personaje>> personajes(){
        return personajesLiveData;
    }
}
