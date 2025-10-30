package com.bollos18.actividad8.ui.list;

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

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private AnimeAdapter adapter;
    private List<AnimeItem> animeList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);

        animeList = createSampleData();

        adapter = new AnimeAdapter(animeList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return root;
    }

    private List<AnimeItem> createSampleData() {
        List<AnimeItem> data = new ArrayList<>();

        int placeholderImage = R.drawable.ic_launcher_background;

        data.add(new AnimeItem("Dragon Ball Z", "Acción, Aventura", placeholderImage));
        data.add(new AnimeItem("Attack on Titan", "Fantasía oscura, Militar", placeholderImage));
        data.add(new AnimeItem("One Piece", "Aventura, Shonen", placeholderImage));
        data.add(new AnimeItem("Death Note", "Misterio, Thriller", placeholderImage));
        data.add(new AnimeItem("My Hero Academia", "Superhéroes, Escuela", placeholderImage));
        data.add(new AnimeItem("Jujutsu Kaisen", "Sobrenatural, Lucha", placeholderImage));

        return data;
    }
}
