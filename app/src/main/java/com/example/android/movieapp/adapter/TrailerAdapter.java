package com.example.android.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.movieapp.R;
import com.example.android.movieapp.model.Review;
import com.example.android.movieapp.model.Trailer;

import java.util.List;

/**
 * Created by ahmed on 28/09/18.
 */

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerViewHolde> {

    private static final String TAG = ReviewAdapter.class.getSimpleName();

    final private TrailerItemClickListener mOnClickListener;

    List<Trailer> trailers;

    public TrailerAdapter(List<Trailer> trailers, TrailerItemClickListener mOnClickListener) {
        this.trailers = trailers;
        this.mOnClickListener = mOnClickListener;
    }

    public interface TrailerItemClickListener {
        void onTrailerItemClick(int clickedItemIndex);
    }

    @NonNull
    @Override
    public TrailerAdapter.TrailerViewHolde onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        Context context = viewGroup.getContext();
        int layout = R.layout.trailer_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout, viewGroup, false);

        return new TrailerViewHolde(view);
    }


    @Override
    public void onBindViewHolder(@NonNull TrailerAdapter.TrailerViewHolde holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    class TrailerViewHolde extends RecyclerView.ViewHolder
            implements View.OnClickListener {


        TrailerViewHolde(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onTrailerItemClick(clickedPosition);
        }

        void bind(int position) {
            ///
        }
    }
}
