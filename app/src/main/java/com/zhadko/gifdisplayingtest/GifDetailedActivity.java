package com.zhadko.gifdisplayingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

public class GifDetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_detailed);

        ImageView gifDetailed = findViewById(R.id.detailedGif);

        int gifPath = getIntent().getIntExtra("GIF_PATH", android.R.drawable.ic_dialog_dialer);
        gifDetailed.setImageResource(gifPath);
    }
}