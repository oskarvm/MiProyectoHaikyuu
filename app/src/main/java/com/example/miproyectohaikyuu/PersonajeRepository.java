package com.example.miproyectohaikyuu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.List;

public class PersonajeRepository {

    LiveData<List<Personaje>> personajesLiveData;

    PersonajeRepository(){
        List<Personaje> personajes = Arrays.asList(
                new Personaje(R.drawable.jugador_karasuno_hinata, "Shoyo Hinata", "Bloqueador","Preparatoria Karasuno", "164.2", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_kageyama, "Tobio Kageyama", "Colocador","Preparatoria Karasuno", "181.9", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_tanaka, "Ryu Tanaka", "Punta","Preparatoria Karasuno", "178.2", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_nishinoya, "Yū Nishinoya","Libero", "Preparatoria Karasuno", "160.5", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_tsuki, "Kei Tsukishima","Bloqueador", "Preparatoria Karasuno", "190.1", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_asahi, "Azumane Asahi","Punta", "Preparatoria Karasuno", "186.4", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_daichi, "Sawamura Daichi","Opuesto", "Preparatoria Karasuno", "176.7", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_sugawara, "Kōshi Sugawara","Colocador", "Preparatoria Karasuno", "174.6", "7", "9", "6", "5", "5"),
                new Personaje(R.drawable.jugador_karasuno_yamaguchi, "Tadashi Yamaguchi","Bloqueaddor", "Preparatoria Karasuno", "180.0f", "7", "9", "6", "5", "5")
                );

                personajesLiveData = new MutableLiveData<>(personajes);
    }

    LiveData<List<Personaje>> personajes(){
        return personajesLiveData;
    }
}
