package com.zhadko.gifdisplayingtest.models;

import com.google.gson.annotations.SerializedName;

public class ImageResources {

    @SerializedName("original")
    OriginalSizeRecource originalRecource;

    public OriginalSizeRecource getOriginalRecource() {
        return originalRecource;
    }

    public void setOriginalRecource(OriginalSizeRecource originalRecource) {
        this.originalRecource = originalRecource;
    }
}
