package com.zhadko.gifdisplayingtest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.zhadko.gifdisplayingtest.R;
import com.zhadko.gifdisplayingtest.adapter.GifListAdapter;
import com.zhadko.gifdisplayingtest.models.Data;
import com.zhadko.gifdisplayingtest.models.Gif;
import com.zhadko.gifdisplayingtest.network.RequestInterface;
import com.zhadko.gifdisplayingtest.network.RetrofitClient;
import com.zhadko.gifdisplayingtest.ui.GifDetailedActivity;
import com.zhadko.gifdisplayingtest.utils.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements GifListAdapter.onGifListener {

    RecyclerView gifRecyclerView;
    List<Gif> gifList;
    GifListAdapter gifListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState   ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gifList = new ArrayList<>();
        gifRecyclerView = findViewById(R.id.GifList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        gifRecyclerView.setLayoutManager(layoutManager);
        gifListAdapter = new GifListAdapter(getApplicationContext(), gifList, this);
        gifRecyclerView.setAdapter(gifListAdapter);

        RequestInterface requestInterface = RetrofitClient.getUser().create(RequestInterface.class);
        Call<Data> call = requestInterface.getGifList(NetworkUtils.API_KEY);

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                gifList = response.body().getGifs();

                Log.d("TAG","Response = "+gifList);
                gifListAdapter.setGifList(gifList);

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Something went wrong, check you internet connection and try again", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onGifClick(int position) {
        gifList.get(position);
        Intent gifIntent = new Intent(this, GifDetailedActivity.class);
        gifIntent.putExtra("GIF_PATH", gifList.get(position).getGrafficResources().getOriginalRecource().getUrl_path());
        startActivity(gifIntent);
    }
}