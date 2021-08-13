package com.zhadko.gifdisplayingtest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhadko.gifdisplayingtest.R;
import com.zhadko.gifdisplayingtest.models.Gif;

import java.util.ArrayList;

public class GifListAdapter extends RecyclerView.Adapter<GifListAdapter.ViewHolder> {

    public ArrayList<Gif> gifList;
    private onGifListener mOnGifListener;

    public GifListAdapter(ArrayList<Gif> gifList, onGifListener onGifListener) {
        this.gifList = gifList;
        this.mOnGifListener = onGifListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gif_list_item, parent, false);

        return new ViewHolder(view, mOnGifListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.gifView.setImageResource(gifList.get(position).getGifPath());
        holder.title.setText(gifList.get(position).getGifTitle());
        holder.date.setText(gifList.get(position).getDateCreationGif());
    }

    @Override
    public int getItemCount() {
        return gifList.size();

    }



    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView gifView;
        TextView title;
        TextView date;
        onGifListener onGifListener;

        public ViewHolder(@NonNull View itemView, onGifListener onGifListener) {
            super(itemView);
            this.onGifListener = onGifListener;
            gifView = itemView.findViewById(R.id.GifImage);
            title = itemView.findViewById(R.id.GifTitle);
            date = itemView.findViewById(R.id.GifDateCreation);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onGifListener.onGifCLick(getAdapterPosition());
        }
    }
    public interface onGifListener {
        void onGifCLick(int position);

    }

}
