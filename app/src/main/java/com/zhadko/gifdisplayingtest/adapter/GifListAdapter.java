package com.zhadko.gifdisplayingtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zhadko.gifdisplayingtest.R;
import com.zhadko.gifdisplayingtest.models.Gif;

import java.util.List;

public class GifListAdapter extends RecyclerView.Adapter<GifListAdapter.ViewHolder> {

    Context context;
    public List<Gif> gifList;
    onGifListener onGifListener;

    public GifListAdapter(Context context, List<Gif> gifList,onGifListener onGifListener) {
        this.context = context;
        this.gifList = gifList;
        this.onGifListener = onGifListener;
    }

    public void setGifList(List<Gif> gifList) {
        this.gifList = gifList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gif_list_item, parent, false);
        return new ViewHolder(view, onGifListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(gifList.get(position).getTitle());
        holder.date.setText(gifList.get(position).getImport_datetime());
        Glide.with(context).load(gifList.get(position).getGrafficResources().getOriginalRecource().getUrl_path()).into(holder.gifView);
    }

    @Override
    public int getItemCount() {
        return gifList.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView gifView;
        TextView title;
        TextView date;
        onGifListener onGifListener;

        public ViewHolder(@NonNull View itemView,onGifListener onGifListener) {
            super(itemView);
            gifView = itemView.findViewById(R.id.GifImage);
            title = itemView.findViewById(R.id.GifTitle);
            date = itemView.findViewById(R.id.GifDateCreation);
            this.onGifListener = onGifListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onGifListener.onGifClick(getAdapterPosition());
        }
    }

    public interface onGifListener {
        void onGifClick(int position);
    }
}
