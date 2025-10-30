package com.bollos18.actividad8.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bollos18.actividad8.data.model.Anime;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<List<Anime>> _animeList = new MutableLiveData<>();
    public LiveData<List<Anime>> getAnimeList() {
        return _animeList;
    }

    public HomeViewModel(/* Aquí iría el AnimeRepository si usaras Dagger 2 */) {
        loadAnimeData();
    }

    private void loadAnimeData() {
    }
}