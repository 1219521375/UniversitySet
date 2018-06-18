package com.example.pokestar.universityset.Data;

/**
 * Created by PokeStar on 2018/6/17.
 */

public class User{
    private String things;
    private int imageId;
    private String name;
    public User(int imageId,String name,String things){
        this.things = things;
        this.imageId = imageId;
        this.name = name;
    }

    public String getThings(){
        return things;
    }
    public int getImageId(){
        return imageId;
    }
    public String getName(){
        return name;
    }
}
