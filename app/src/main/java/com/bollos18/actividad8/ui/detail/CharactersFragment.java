package com.bollos18.actividad8.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bollos18.actividad8.R;
import com.bollos18.actividad8.data.model.Anime;

import java.util.Collections;


public class CharactersFragment extends Fragment {

    private static final String ARG_ANIME = "anime";
    private Anime anime;
    private RecyclerView recyclerView;

    public static CharactersFragment newInstance(Anime anime) {
        CharactersFragment fragment = new CharactersFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_ANIME, "anime");
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
        return inflater.inflate(R.layout.fragment_characters, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewCharacters);

        if (anime != null && anime.getCharacters() != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            CharactersAdapter adapter = new CharactersAdapter(Collections.singletonList(anime.getCharacters()));
            recyclerView.setAdapter(adapter);

            recyclerView.setHasFixedSize(true);
        }
    }
}