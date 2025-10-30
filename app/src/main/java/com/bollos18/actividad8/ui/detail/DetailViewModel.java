package com.bollos18.actividad8.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.bollos18.actividad8.data.model.Anime;
import com.bollos18.actividad8.data.repository.AnimeRepository;

public class DetailViewModel extends ViewModel {

    public final LiveData<Anime> animeDetail;

    public DetailViewModel(AnimeRepository repository, long animeId) {
        this.animeDetail = repository.getAnimeById(animeId);

    }

    public LiveData<Anime> getAnimeDetail() {
        return animeDetail;
    }
}