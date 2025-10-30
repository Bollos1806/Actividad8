package com.bollos18.actividad8.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bollos18.actividad8.ui.list.AnimeAdapter;
import com.bollos18.actividad8.R;
import com.bollos18.actividad8.data.model.Anime;
public class HomeFragment extends Fragment implements AnimeAdapter.OnItemClickListener {

    private HomeViewModel viewModel;

    private AnimeAdapter adapter;
    private RecyclerView recyclerView;
    private NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postponeEnterTransition();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = NavHostFragment.findNavController(this);
        // La inicialización del ViewModel es estándar y no depende de Hilt. ¡Perfecto!
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        recyclerView = view.findViewById(R.id.recyclerViewAnimeList);
        setupRecyclerView();

        setupObservers();
    }

    private void setupRecyclerView() {
        adapter = new AnimeAdapter(this);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);
        recyclerView.getViewTreeObserver().addOnPreDrawListener(() -> {
            startPostponedEnterTransition();
            return true;
        });
    }

    private void setupObservers() {
        viewModel.getAnimeList().observe(getViewLifecycleOwner(), animeList -> {
            if (animeList != null) {
                adapter.submitList(animeList);
            }
        });
    }

    @Override
    public void onItemClick(Anime anime, View sharedElement) {
        Bundle args = new Bundle();
        args.putParcelable("anime", anime);
        FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                .addSharedElement(sharedElement, sharedElement.getTransitionName())
                .build();
        navController.navigate(R.id.action_homeFragment_to_detailFragment, args, null, extras);
    }
}
