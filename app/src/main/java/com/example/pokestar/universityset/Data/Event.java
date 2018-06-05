package com.example.pokestar.universityset.Data;

/**
 * Created by PokeStar on 2018/6/4.
 */

public class Event {

    private String depict;

    private String title;

    public Event(String title, String depict) {
        this.depict = depict;
        this.title = title;
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


}
