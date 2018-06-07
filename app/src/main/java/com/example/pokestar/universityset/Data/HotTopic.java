package com.example.pokestar.universityset.Data;

/**
 * Created by PokeStar on 2018/6/7.
 */

public class HotTopic {
    private String title;
    private String ImageUrl;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public HotTopic(String title, String imageUrl, int number) {
        this.title = title;
        ImageUrl = imageUrl;
        this.number = number;
    }

    public HotTopic(String title, String imageUrl) {
        this.title = title;
        ImageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
