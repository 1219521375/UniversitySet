package com.example.pokestar.universityset.Data;

import java.util.UUID;

/**
 * Created by PokeStar on 2018/6/4.
 */

public class Event {

    private UUID mId;

    private String depict;

    private String title;

    private String ImageUrl;

    public Event(){
        this(UUID.randomUUID());
    }

    public Event(String title, String depict) {
        mId = UUID.randomUUID();
        this.depict = depict;
        this.title = title;
    }

    public Event(String title, String depict, String imageUrl) {
        mId = UUID.randomUUID();
        this.depict = depict;
        this.title = title;
        ImageUrl = imageUrl;
    }

    public Event(UUID uuid) {
        mId = uuid;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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


    /*public String getPhotoFilename() {
        return "IMG_" + getId().toString() + ".jpg";
    }*/
}
