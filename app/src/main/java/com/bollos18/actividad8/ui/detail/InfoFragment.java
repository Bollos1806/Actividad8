package com.bollos18.actividad8.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bollos18.actividad8.R;
import com.bollos18.actividad8.data.model.Anime;

import java.util.Locale;

public class InfoFragment extends Fragment {

    private static final String ARG_ANIME = "anime";
    private Anime anime;

    // --- Vistas de la UI ---
    private TextView textViewRating;
    private TextView textViewStudio;
    private TextView textViewGenres;

    public static InfoFragment newInstance(Anime anime) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_ANIME, anime);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            anime = (Anime) getArguments().getSerializable(ARG_ANIME);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        populateUI();
    }

    private void initViews(View view) {
        textViewRating = view.findViewById(R.id.textViewRating);
        textViewStudio = view.findViewById(R.id.textViewStudio);
        textViewGenres = view.findViewById(R.id.textViewGenres);
    }

    private void populateUI() {
        if (anime != null) {
            String formattedRating = String.format(Locale.getDefault(), "%.2f / 10", anime.getRating());
            textViewRating.setText(formattedRating);

            textViewStudio.setText(anime.getStudio());

            if (anime.getGenres() != null && !anime.getGenres().isEmpty()) {
                String genresText = String.join(", ", anime.getGenres());
                textViewGenres.setText(genresText);
            } else {
                textViewGenres.setText("N/A");
            }
        }
    }
}
