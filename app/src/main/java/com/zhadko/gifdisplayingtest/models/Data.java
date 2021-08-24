package com.zhadko.gifdisplayingtest.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("data")
    public List<Gif> gifs;

    public List<Gif> getGifs() {
        return gifs;
    }

    public void setGifs(List<Gif> gifs) {
        this.gifs = gifs;
    }
}
