package com.bollos18.actividad8.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bollos18.actividad8.data.model.Anime;
import java.util.ArrayList;
import java.util.List;

public class AnimeRepository {

    private static volatile AnimeRepository INSTANCE;
    private final List<Anime> animeDataList;

    private final MutableLiveData<List<Anime>> allAnime;

    private AnimeRepository() {
        animeDataList = new ArrayList<>();
        allAnime = new MutableLiveData<>();

        loadInitialData();
        allAnime.setValue(animeDataList);
    }

    public static AnimeRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (AnimeRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AnimeRepository();
                }
            }
        }
        return INSTANCE;
    }

    public LiveData<List<Anime>> getAllAnime() {
        return allAnime;
    }

    public LiveData<Anime> getAnimeById(long id) {
        MutableLiveData<Anime> animeLiveData = new MutableLiveData<>();
        Anime foundAnime = null;
        for (Anime anime : animeDataList) {
            if (anime.getId() == id) {
                foundAnime = anime;
                break;
            }
        }
        animeLiveData.setValue(foundAnime);
        return animeLiveData;
    }


    private void loadInitialData() {
        animeDataList.add(new Anime(
                1L,
                "Fullmetal Alchemist: Brotherhood",
                "La búsqueda de la Piedra Filosofal.",
                9.19,
                "https://placehold.co/100x150/FFC0CB/000?text=FMA:B"
        ));
        animeDataList.add(new Anime(
                2L,
                "Attack on Titan",
                "La humanidad lucha por sobrevivir contra los titanes.",
                8.90,
                "https://placehold.co/100x150/ADD8E6/000?text=AoT"
        ));
        animeDataList.add(new Anime(
                3L,
                "Jujutsu Kaisen",
                "Un estudiante se une a una organización secreta para exorcizar maldiciones.",
                8.71,
                "https://placehold.co/100x150/90EE90/000?text=JK"
        ));
    }
}
