package com.zhadko.gifdisplayingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.zhadko.gifdisplayingtest.adapter.GifListAdapter;
import com.zhadko.gifdisplayingtest.models.Gif;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GifListAdapter.onGifListener {

    private RecyclerView gifRecyclerView;
    private ArrayList<Gif> gifArrayList = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
    private GifListAdapter gifListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gifArrayList.add(new Gif(R.drawable.ic_launcher_background, "Hello", "Yo"));
        gifArrayList.add(new Gif(R.drawable.ic_launcher_background, "Hello", "Yo"));
        gifArrayList.add(new Gif(R.drawable.ic_launcher_background, "Hello", "Yo"));
        gifArrayList.add(new Gif(R.drawable.ic_launcher_background, "Hello", "Yo"));


        gifRecyclerView = findViewById(R.id.GifList);
        gifListAdapter = new GifListAdapter(gifArrayList, this);
        gifRecyclerView.setLayoutManager(layoutManager);
        gifRecyclerView.setAdapter(gifListAdapter);

    }

    @Override
    public void onGifCLick(int position) {
        gifArrayList.get(position);
        Intent gifIntent = new Intent(getBaseContext(), GifDetailedActivity.class);
        gifIntent.putExtra("GIF_PATH", gifArrayList.get(position).getGifPath());
        startActivity(gifIntent);
    }
}