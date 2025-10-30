package com.bollos18.actividad8.detail;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bollos18.actividad8.data.model.Anime;

public class DetailPagerAdapter extends FragmentStateAdapter {

    private final Anime anime;
    private final int NUM_TABS = 2;

    /**
     * Constructor.
     * @param fragment El DetailFragment que aloja este ViewPager2.
     * @param anime El objeto Anime con todos los detalles necesarios.
     */
    public DetailPagerAdapter(@NonNull Fragment fragment, Anime anime) {
        super(fragment);
        this.anime = anime;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Retorna el Fragmento basado en la posición de la pestaña
        switch (position) {
            case 0:
                // Posición 0: Pestaña de Personajes
                return CharactersFragment.newInstance(anime);
            case 1:
                // Posición 1: Pestaña de Información Adicional
                return InfoFragment.newInstance(anime);
            default:
                // Fallback, aunque con NUM_TABS=2 nunca debería ocurrir
                return CharactersFragment.newInstance(anime);
        }
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }
}
