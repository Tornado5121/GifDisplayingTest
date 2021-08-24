package com.zhadko.gifdisplayingtest.models;

import com.google.gson.annotations.SerializedName;

public class OriginalSizeRecource {
    @SerializedName("url")
    String url_path;

    public String getUrl_path() {
        return url_path;
    }

    public void setUrl_path(String url_path) {
        this.url_path = url_path;
    }
}
