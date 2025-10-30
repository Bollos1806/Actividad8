package com.bollos18.actividad8.ui.list;

import com.bollos18.actividad8.data.model.Anime;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bollos18.actividad8.R;
public class AnimeAdapter extends ListAdapter<Anime, AnimeAdapter.AnimeViewHolder> {

    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Anime anime, View sharedElement);
    }

    public AnimeAdapter(OnItemClickListener listener) {
        super(DIFF_CALLBACK);
        this.listener = listener;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_anime, parent, false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        Anime currentAnime = getItem(position);
        holder.bind(currentAnime, listener);
    }
    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        public final ImageView coverImageView;
        public final TextView titleTextView;

        public AnimeViewHolder(View view) {
            super(view);
            coverImageView = view.findViewById(R.id.coverImageView);
            titleTextView = view.findViewById(R.id.titleTextView);
        }

        public void bind(final Anime anime, final OnItemClickListener listener) {
            titleTextView.setText(anime.getTitle());


            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(anime, coverImageView);
                }
            });

            coverImageView.setTransitionName("anime_image_" + anime.getId());
        }
    }

    private static final DiffUtil.ItemCallback<Anime> DIFF_CALLBACK = new DiffUtil.ItemCallback<Anime>() {
        @Override
        public boolean areItemsTheSame(@NonNull Anime oldItem, @NonNull Anime newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Anime oldItem, @NonNull Anime newItem) {
            return oldItem.equals(newItem);
        }
    };
}
