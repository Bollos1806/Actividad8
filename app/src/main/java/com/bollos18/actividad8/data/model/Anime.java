package com.bollos18.actividad8;

import java.io.Serializable;
import java.util.List;

public class Anime implements Serializable {

    private String id;
    private String title;
    private String synopsis;
    private String posterUrl;
    private float rating;
    private int episodes;

    private String studio;
    private List<String> genres;
    private List<Character> characters;

    public Anime() {
    }

    public Anime(String id, String title, String synopsis, String posterUrl, float rating, int episodes,
                 String studio, List<String> genres, List<Character> characters) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.posterUrl = posterUrl;
        this.rating = rating;
        this.episodes = episodes;
        this.studio = studio;
        this.genres = genres;
        this.characters = characters;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }


    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
