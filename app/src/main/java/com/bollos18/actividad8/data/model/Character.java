package com.bollos18.actividad8;

public class Character {

    private String id;
    private String animeId;
    private String name;
    private String role;
    private String imageUrl;

    public Character() {
    }

    public Character(String id, String animeId, String name, String role, String imageUrl) {
        this.id = id;
        this.animeId = animeId;
        this.name = name;
        this.role = role;
        this.imageUrl = imageUrl;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAnimeId() {
        return animeId;
    }
    public void setAnimeId(String animeId) {
        this.animeId = animeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
