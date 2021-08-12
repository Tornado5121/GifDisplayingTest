package com.zhadko.gifdisplayingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.zhadko.gifdisplayingtest.adapter.GifListAdapter;
import com.zhadko.gifdisplayingtest.models.Gif;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView gifRecyclerView;
    private ArrayList<Gif> gifArrayList;
    private RecyclerView.LayoutManager layoutManager;
    private GifListAdapter gifListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        gifRecyclerView = findViewById(R.id.GifList);
        gifListAdapter = new GifListAdapter(gifArrayList);
        gifRecyclerView.setLayoutManager(layoutManager);
        gifRecyclerView.setAdapter(gifListAdapter);

    }
}