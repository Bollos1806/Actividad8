package com.bollos18.actividad8.ui.detail;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bollos18.actividad8.data.repository.AnimeRepository;

public class DetailViewModelFactory implements ViewModelProvider.Factory {

    private final AnimeRepository repository;
    private final long animeId;

    public DetailViewModelFactory(AnimeRepository repository, long animeId) {
        this.repository = repository;
        this.animeId = animeId;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            try {
                return (T) new DetailViewModel(repository, animeId);
            } catch (Exception e) {
                throw new IllegalArgumentException("Error creando DetailViewModel: " + e.getMessage(), e);
            }
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}