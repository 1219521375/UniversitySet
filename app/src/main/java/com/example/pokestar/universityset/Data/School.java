package com.example.pokestar.universityset.Data;

import java.lang.ref.SoftReference;

/**
 * Created by PokeStar on 2018/6/19.
 */

public class School {

    private String name;

    private String imageUrl;

    public School(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
