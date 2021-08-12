package com.zhadko.gifdisplayingtest.models;

public class Gif {

    int gifPath;
    String gifTitle;
    String dateCreationGif;

    public Gif() {
            }

    public Gif(int gifPath, String gifTitle, String dateCreationGif) {
        this.gifPath = gifPath;
        this.gifTitle = gifTitle;
        this.dateCreationGif = dateCreationGif;
    }

    public int getGifPath() {
        return gifPath;
    }

    public void setGifPath(int gifPath) {
        this.gifPath = gifPath;
    }

    public String getGifTitle() {
        return gifTitle;
    }

    public void setGifTitle(String gifTitle) {
        this.gifTitle = gifTitle;
    }

    public String getDateCreationGif() {
        return dateCreationGif;
    }

    public void setDateCreationGif(String dateCreationGif) {
        this.dateCreationGif = dateCreationGif;
    }
}
