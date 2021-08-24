package com.zhadko.gifdisplayingtest.models;

import com.google.gson.annotations.SerializedName;

public class Gif {

    @SerializedName("images")
    ImageResources grafficResources;

    @SerializedName("title")
    String title;

    @SerializedName("import_datetime")
    String import_datetime;

    public Gif() {
            }

    public Gif(ImageResources grafficResources, String title, String import_datetime) {
        this.grafficResources = grafficResources;
        this.title = title;
        this.import_datetime = import_datetime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImport_datetime() {
        return import_datetime;
    }

    public void setImport_datetime(String import_datetime) {
        this.import_datetime = import_datetime;
    }

    public ImageResources getGrafficResources() {
        return grafficResources;
    }

    public void setGrafficResources(ImageResources grafficResources) {
        this.grafficResources = grafficResources;
    }
}
