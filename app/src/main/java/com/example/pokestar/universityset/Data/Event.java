package com.example.pokestar.universityset.Data;

/**
 * Created by PokeStar on 2018/6/4.
 */

public class Event {

    private String depict;

    private String ImageUrl;

    public Event(String depict, String imageUrl) {
        this.depict = depict;
        ImageUrl = imageUrl;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
