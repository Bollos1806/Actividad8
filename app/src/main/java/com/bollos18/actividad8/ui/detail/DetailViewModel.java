package com.bollos18.actividad8.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.bollos18.actividad8.data.model.Anime;
import com.bollos18.actividad8.data.repository.AnimeRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@HiltViewModel
public class DetailViewModel extends ViewModel {

    private final AnimeRepository repository;

    @Inject
    public DetailViewModel(AnimeRepository repository) {
        this.repository = repository;
    }

    public LiveData<Anime> getAnimeDetails(long animeId) {
        return repository.getAnimeById(animeId);
    }
}