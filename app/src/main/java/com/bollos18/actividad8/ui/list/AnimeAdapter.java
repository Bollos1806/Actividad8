package com.bollos18.actividad8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bollos18.actividad8.R;
import com.bollos18.actividad8.data.model.Anime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {

    private List<Anime> animeList = new ArrayList<>();
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Anime anime, View sharedElement);
    }

    public AnimeAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }
    public void submitList(List<Anime> newAnimeList) {
        this.animeList = newAnimeList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_anime_card, parent, false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        Anime anime = animeList.get(position);
        holder.bind(anime, listener);
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }
    static class AnimeViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageViewPoster;
        private final TextView textViewTitle;
        private final TextView textViewRating;

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPoster = itemView.findViewById(R.id.imageViewPoster);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewRating = itemView.findViewById(R.id.textViewRating);
        }

        public void bind(final Anime anime, final OnItemClickListener listener) {
            Glide.with(itemView.getContext())
                    .load(anime.getPosterUrl())
                    .placeholder(R.drawable.ic_placeholder_anime)
                    .error(R.drawable.ic_placeholder_anime)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(imageViewPoster);

            textViewTitle.setText(anime.getTitle());
            String formattedRating = String.format(Locale.getDefault(), "%.1f", anime.getRating());
            textViewRating.setText(formattedRating);
            String transitionName = "poster_" + anime.getId();
            imageViewPoster.setTransitionName(transitionName);

            itemView.setOnClickListener(v -> {
                listener.onItemClick(anime, imageViewPoster);
            });
        }
    }
}