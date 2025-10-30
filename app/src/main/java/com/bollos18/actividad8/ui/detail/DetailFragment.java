package com.bollos18.actividad8.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bollos18.actividad8.data.model.Anime;
import com.bollos18.actividad8.data.repository.AnimeRepository;
import com.bollos18.actividad8.R;

public class DetailFragment extends Fragment {

    private DetailViewModel viewModel;
    private TextView titleTextView;
    private TextView synopsisTextView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        titleTextView = view.findViewById(R.id.anime_title);
        synopsisTextView = view.findViewById(R.id.anime_synopsis);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        long animeId = DetailFragmentArgs.fromBundle(getArguments()).getAnimeId();

        AnimeRepository repository = AnimeRepository.getInstance();

        DetailViewModelFactory factory = new DetailViewModelFactory(repository, animeId);
        viewModel = new ViewModelProvider(this, factory).get(DetailViewModel.class);

        viewModel.getAnimeDetail().observe(getViewLifecycleOwner(), anime -> {
            if (anime != null) {
                displayAnimeDetail(anime);
            } else {
                titleTextView.setText("Error: Anime no encontrado");
                synopsisTextView.setText("");
            }
        });
    }

    private void displayAnimeDetail(Anime anime) {
        titleTextView.setText(anime.getTitle());
        synopsisTextView.setText(anime.getSynopsis());
    }
}
