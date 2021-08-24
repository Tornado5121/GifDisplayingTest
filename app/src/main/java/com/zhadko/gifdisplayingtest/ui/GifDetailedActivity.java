package com.zhadko.gifdisplayingtest.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.module.AppGlideModule;
import com.zhadko.gifdisplayingtest.R;

public class GifDetailedActivity extends AppCompatActivity {

    String gifPath;
    ImageView gifDetailed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_detailed);

        gifDetailed = findViewById(R.id.detailedGif);

        gifPath = getIntent().getStringExtra("GIF_PATH");
                Glide.with(this).asGif().load(gifPath).into(gifDetailed);

    }
}