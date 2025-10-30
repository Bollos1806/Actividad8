package com.bollos18.actividad8.ui.list;

public class AnimeItem {
    private final String title;
    private final String genre;
    private final int coverResourceId;
    public AnimeItem(String title, String genre, int coverResourceId) {
        this.title = title;
        this.genre = genre;
        this.coverResourceId = coverResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getCoverResourceId() {
        return coverResourceId;
    }
}