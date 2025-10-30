package com.bollos18.actividad8.detail;

import android.content.Intent;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;
import com.bollos18.actividad8.R;
import com.bollos18.actividad8.data.model.Anime;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import dagger.hilt.android.AndroidEntryPoint;

// Permite la inyección de dependencias (ViewModel)
@AndroidEntryPoint
public class DetailFragment extends Fragment {

    private DetailViewModel viewModel;
    private Anime currentAnime;

    // Vistas de la UI
    private ImageView imageViewDetailPoster;
    private TextView textViewDetailTitle;
    private TextView textViewSynopsis;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    private FloatingActionButton fabShare;
    private Toolbar toolbarDetail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSharedElementEnterTransition(TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move));
        setSharedElementReturnTransition(TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);

        setupToolbar();

        viewModel = new ViewModelProvider(this).get(DetailViewModel.class);

        setupObservers();

        fabShare.setOnClickListener(v -> shareAnime());
    }

    private void initViews(View view) {
        imageViewDetailPoster = view.findViewById(R.id.imageViewDetailPoster);
        textViewDetailTitle = view.findViewById(R.id.textViewDetailTitle);
        textViewSynopsis = view.findViewById(R.id.textViewSynopsis);
        collapsingToolbarLayout = view.findViewById(R.id.collapsingToolbarLayout);
        viewPager2 = view.findViewById(R.id.viewPager2);
        tabLayout = view.findViewById(R.id.tabLayout);
        fabShare = view.findViewById(R.id.fabShare);
        toolbarDetail = view.findViewById(R.id.toolbarDetail);
    }

    private void setupToolbar() {
        // Configura el botón de regreso
        toolbarDetail.setNavigationOnClickListener(v ->
                NavHostFragment.findNavController(DetailFragment.this).navigateUp()
        );
    }

    private void setupObservers() {
        long animeId = 1L;

        viewModel.getAnimeDetails(animeId).observe(getViewLifecycleOwner(), anime -> {
            if (anime != null) {
                currentAnime = anime;
                populateUI(anime);
                setupViewPager(anime);
            }
        });
    }

    private void populateUI(Anime anime) {
        // Asignar el nombre de la transición para la imagen (Tema 7)
        imageViewDetailPoster.setTransitionName("poster_" + anime.getId());

        Glide.with(this)
                .load(anime.getPosterUrl())
                .placeholder(R.drawable.ic_placeholder_anime)
                .error(R.drawable.ic_placeholder_anime)
                .into(imageViewDetailPoster);

        textViewDetailTitle.setText(anime.getTitle());
        textViewSynopsis.setText(anime.getSynopsis());

        collapsingToolbarLayout.setTitle(anime.getTitle());
    }

    private void setupViewPager(Anime anime) {
        // Crear el adaptador e inyectar el objeto Anime
        DetailPagerAdapter adapter = new DetailPagerAdapter(this, anime);
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            if (position == 0) {
                tab.setText("Personajes");
            } else {
                tab.setText("Información");
            }
        }).attach();
    }

    private void shareAnime() {
        if (currentAnime != null) {
            // Intent Implícito para compartir (Tema 8)
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            String shareText = "¡Mira este anime genial! " + currentAnime.getTitle() +
                    "\nSinopsis: " + currentAnime.getSynopsis();
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
            startActivity(Intent.createChooser(shareIntent, "Compartir anime vía..."));
        }
    }
}