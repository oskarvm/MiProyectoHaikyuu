package com.example.miproyectohaikyuu.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.miproyectohaikyuu.R;

import java.util.Arrays;
import java.util.List;

public class EquipoPosicionRepository {

    public LiveData<List<EquipoPosicion>> equipoposicionLiveData;

    public EquipoPosicionRepository() {
        List<EquipoPosicion> equipoposicion = Arrays.asList(
                new EquipoPosicion(R.drawable.jugador_karasuno_hinata, "Shoyo Hinata", "Bloqueador", "Preparatoria Karasuno"),
                new EquipoPosicion(R.drawable.jugador_karasuno_kageyama, "Tobio Kageyama", "Colocador", "Preparatoria Karasuno"),
                new EquipoPosicion(R.drawable.jugador_karasuno_tanaka, "Ryu Tanaka", "Punta", "Preparatoria Karasuno"),
                new EquipoPosicion(R.drawable.jugador_karasuno_nishinoya, "Yū Nishinoya", "Libero", "Preparatoria Karasuno"),
                new EquipoPosicion(R.drawable.jugador_karasuno_tsuki,"Kei Tsukishima", "Bloqueador", "Preparatoria Karasuno"),
                new EquipoPosicion(R.drawable.jugador_karasuno_asahi, "Azumane Asahi", "Punta", "Preparatoria Karasuno"),
                new EquipoPosicion(R.drawable.jugador_karasuno_daichi,"Sawamura Daichi", "Opuesto", "Preparatoria Karasuno"),
                new EquipoPosicion(R.drawable.jugador_karasuno_sugawara, "Kōshi Sugawara", "Colocador", "Preparatoria Karasuno"),
                new EquipoPosicion(R.drawable.jugador_karasuno_yamaguchi, "Tadashi Yamaguchi", "Bloqueaddor", "Preparatoria Karasuno"),

                new EquipoPosicion(R.drawable.jugador_nekoma_kuroo, "Tetsurō Kuroo","Bloqueador", "Preparatoria Nekoma"),
                new EquipoPosicion(R.drawable.jugador_nekoma_kai,"Nobuyuki Kai","Opuesto", "Preparatoria Nekoma"),
                new EquipoPosicion(R.drawable.jugador_nekoma_yaku,"Morisuke Yaku","Libero", "Preparatoria Nekoma"),
                new EquipoPosicion(R.drawable.jugador_nekoma_yamamoto,"Taketora Yamamoto","Punta", "Preparatoria Nekoma"),
                new EquipoPosicion(R.drawable.jugador_nekoma_kenma,"Kozume Kenma","Colocador", "Preparatoria Nekoma"),
                new EquipoPosicion(R.drawable.jugador_nekoma_fukunaga,"Shōhei Fukugana","Punta", "Preparatoria Nekoma"),
                new EquipoPosicion(R.drawable.jugador_nekoma_lev,"Lev Haiba","Bloqueador", "Preparatoria Nekoma"),

                new EquipoPosicion(R.drawable.jugador_kamomedai_suwa,"Aichiki Suwa","Colocador", "Preparatoria Kamomedai"),
                new EquipoPosicion(R.drawable.jugador_kamomedai_nozawa,"Izuru Nozawa","Punta", "Preparatoria Kamomedai"),
                new EquipoPosicion(R.drawable.jugador_kamomedai_hoshiumi,"Kōrai Hoshiumi","Puntta", "Preparatoria Kamomedai"),
                new EquipoPosicion(R.drawable.jugador_kamomedai_hirugami,"Sachirō Hirugami","Bloqueador", "Preparatoria Kamomedai"),
                new EquipoPosicion(R.drawable.jugador_kamomedai_hakuba,"Gao Hakuba","Opuesto", "Preparatoria Kamomedai"),
                new EquipoPosicion(R.drawable.jugador_kamomedai_bessho, "Kazuyoshi Bessho","Bloqueador", "Preparatoria Kamomedai"),
                new EquipoPosicion(R.drawable.jugador_kamomedai_kanbayashi,"Keiichirō Kanbayashi","Libero", "Preparatoria Kamomedai"),

                new EquipoPosicion(R.drawable.jugador_fukorodani_washio,"Tatsuki Washio","Bloqueador", "Academia Fukorodani"),
                new EquipoPosicion(R.drawable.jugador_fukorodani_sarukui,"Yamato Sarukui","Punta", "Academia Fukorodani"),
                new EquipoPosicion(R.drawable.jugador_fukorodani_bokuto,"Kōtarō Bokuto","Punta", "Academia Fukorodani"),
                new EquipoPosicion(R.drawable.jugador_fukorodani_akaashi,"Keiji Akaashi","Colocador", "Academia Fukorodani"),
                new EquipoPosicion(R.drawable.jugador_fukorodani_konoha,"Akinori Konoha","Opuesto", "Academia Fukorodani"),
                new EquipoPosicion(R.drawable.jugador_fukorodani_komi,"Haruki Komi","Libero", "Academia Fukorodani"),
                new EquipoPosicion(R.drawable.jugador_fukorodani_onaga,"Wataru Onaga","Bloqueador", "Academia Fukorodani"),

                new EquipoPosicion(R.drawable.jugador_date_aone,"Takanobu Aone","Bloqueador", "Preparatoria Tecnica de Date"),
                new EquipoPosicion(R.drawable.jugador_date_futakuchi,"Kenji Futakuchi","Punta", "Preparatoria Tecnica de Date"),
                new EquipoPosicion(R.drawable.jugador_date_obara,"Yukata Obara","Punta", "Preparatoria Tecnica de Date"),
                new EquipoPosicion(R.drawable.jugador_date_kogagenawa,"Kanji Koganegawa","Colocador", "Preparatoria Tecnica de Date"),
                new EquipoPosicion(R.drawable.jugador_date_onagawa,"Tarō Onagawa","Opuesto", "Preparatoria Tecnica de Date"),
                new EquipoPosicion(R.drawable.jugador_date_fukiage,"Jingo Fukiage","Bloqueador", "Preparatoria Tecnica de Date"),
                new EquipoPosicion(R.drawable.jugador_date_sakumani,"Kōsuke Sakunami","Libero", "Preparatoria Tecnica de Date"),

                new EquipoPosicion(R.drawable.jugador_aobajosai_oikawa,"Tōru Oikawa","Colocador", "Preparatoria Aoba Josai"),
                new EquipoPosicion(R.drawable.jugador_aobajosai_matsukawa, "Issei Matsukawa","Bloqueador", "Preparatoria Aoba Josai"),
                new EquipoPosicion(R.drawable.jugador_aobajosai_iwaizumi,"Hajime Iwaizumi","Punta", "Preparatoria Aoba Josai"),
                new EquipoPosicion(R.drawable.jugador_aobajosai_watari, "Shinji Watari","Libero", "Preparatoria Aoba Josai"),
                new EquipoPosicion(R.drawable.jugador_aobajosai_kindaichi, "Yūtarō Kindaichi","Bloqueador", "Preparatoria Aoba Josai"),
                new EquipoPosicion(R.drawable.jugador_aobajosai_kumini,"Akira Kumini","Opuesto", "Preparatoria Aoba Josai"),
                new EquipoPosicion(R.drawable.jugador_aobajosai_kentaro,"Kentarō Kyōtanii","Punta", "Preparatoria Aoba Josai"),

                new EquipoPosicion(R.drawable.jugador_shiratorizawa_ushijima,"Wakathosi Ushijima","Opuesto", "Academia Shiratorizawa"),
                new EquipoPosicion(R.drawable.jugador_shiratorizawa_tendo,"Satori Tendō","Bloqueador", "Academia Shiratorizawa"),
                new EquipoPosicion(R.drawable.jugador_shiratorizawa_shibaru,"Kenjirō Shibaru","Colocador", "Academia Shiratorizawa"),
                new EquipoPosicion(R.drawable.jugador_shiratorizawa_reon, "Reon Ōhira","Punta", "Academia Shiratorizawa"),
                new EquipoPosicion(R.drawable.jugador_shiratorizawa_goshiki, "Tsutomu Goshiki","Punta", "Academia Shiratorizawa"),
                new EquipoPosicion(R.drawable.jugador_shiratorizawa_yamagata,"Hayato Yamagata","Libero", "Academia Shiratorizawa"),
                new EquipoPosicion(R.drawable.jugador_shiratorizawa_kawanishi,"Taichi Kawanishi","Bloqueador", "Academia Shiratorizawa"),

                new EquipoPosicion(R.drawable.jugador_inarizaki_kita, "Shinsuke Kita","Punta", "Preparatoria Inarizaki"),
                new EquipoPosicion(R.drawable.jugador_inarizaki_aran,"Aran Ojiro","Punta", "Preparatoria Inarizaki"),
                new EquipoPosicion(R.drawable.jugador_inarizaki_osamu, "Osamu Miya","Opuesto", "Preparatoria Inarizaki"),
                new EquipoPosicion(R.drawable.jugador_inarizaki_atsumu,"Atsumu Miya","Colocador", "Preparatoria Inarizaki"),
                new EquipoPosicion(R.drawable.jugador_inarizaki_suna, "Rintarō Suna","Bloqueador", "Preparatoria Inarizaki"),
                new EquipoPosicion(R.drawable.jugador_inarizaki_omimi, "Ren Ōmimi","Bloqueador", "Preparatoria Inarizaki"),
                new EquipoPosicion(R.drawable.jugador_inarizaki_akagi,"Michinari Akagi","Libero", "Preparatoria Inarizaki")
        );

        equipoposicionLiveData = new MutableLiveData<>(equipoposicion);
    }

    public LiveData<List<EquipoPosicion>> equipoposicion(){
        return equipoposicionLiveData;
    }
}
