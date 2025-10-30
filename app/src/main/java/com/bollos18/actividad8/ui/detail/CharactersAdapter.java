package com.bollos18.actividad8.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bollos18.actividad8.R;
import com.bollos18.actividad8.data.model.Character;
import com.bumptech.glide.Glide;

import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder> {

    private List<Character> characters;

    public CharactersAdapter(List<Character> characters) {
        this.characters = characters;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characters.get(position);
        holder.bind(character);
    }

    @Override
    public int getItemCount() {
        return characters != null ? characters.size() : 0;
    }
    static class CharacterViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageViewCharacter;
        private final TextView textViewName;
        private final TextView textViewRole;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCharacter = itemView.findViewById(R.id.imageViewCharacter);
            textViewName = itemView.findViewById(R.id.textViewCharacterName);
            textViewRole = itemView.findViewById(R.id.textViewCharacterRole);
        }

        public void bind(Character character) {
            Glide.with(itemView.getContext())
                    .load(character.getImageUrl())
                    .placeholder(R.drawable.ic_placeholder_anime)
                    .error(R.drawable.ic_placeholder_anime)
                    .into(imageViewCharacter);

            textViewName.setText(character.getName());
            textViewRole.setText(character.getRole());

            textViewRole.setBackgroundResource(R.drawable.bg_rounded_tag);
        }
    }
}
