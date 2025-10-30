package com.bollos18.actividad8.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Anime implements Parcelable {
    private final long id;
    private final String title;
    private final String synopsis;
    private final double rating;
    private final String imageUrl;

    public Anime(long id, String title, String synopsis, double rating, String imageUrl) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    public long getId() { return id; }
    public String getTitle() { return title; }
    public String getSynopsis() { return synopsis; }
    public double getRating() { return rating; }
    public String getImageUrl() { return imageUrl; }
    public List<Character> getCharacters() {
        return getCharacters();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anime anime = (Anime) o;
        return id == anime.id &&
                Double.compare(anime.rating, rating) == 0 &&
                Objects.equals(title, anime.title) &&
                Objects.equals(synopsis, anime.synopsis) &&
                Objects.equals(imageUrl, anime.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, synopsis, rating, imageUrl);
    }


    protected Anime(Parcel in) {
        id = in.readLong();
        title = in.readString();
        synopsis = in.readString();
        rating = in.readDouble();
        imageUrl = in.readString();
    }

    public static final Creator<Anime> CREATOR = new Creator<Anime>() {
        @Override
        public Anime createFromParcel(Parcel in) {
            return new Anime(in);
        }

        @Override
        public Anime[] newArray(int size) {
            return new Anime[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(synopsis);
        dest.writeDouble(rating);
        dest.writeString(imageUrl);
    }
}
