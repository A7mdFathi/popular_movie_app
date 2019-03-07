package com.example.android.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.movieapp.R;
import com.example.android.movieapp.model.Review;

import java.util.List;


public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolde> {

    private static final String TAG = ReviewAdapter.class.getSimpleName();

    final private ReviewItemClickListener mOnClickListener;

    List<Review> reviews;


    public ReviewAdapter(List<Review> reviews, ReviewItemClickListener mOnClickListener) {
        this.reviews = reviews;
        this.mOnClickListener = mOnClickListener;

    }

    public interface ReviewItemClickListener {
        void onReviewItemClick(int clickedItemIndex);
    }

    @NonNull
    @Override
    public ReviewAdapter.ReviewViewHolde onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        Context context = viewGroup.getContext();
        int layout = R.layout.review_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout, viewGroup, false);

        return new ReviewViewHolde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.ReviewViewHolde holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    class ReviewViewHolde extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView contentText;

        ReviewViewHolde(View itemView) {
            super(itemView);

            contentText = (TextView) itemView.findViewById(R.id.content_tv);
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            contentText.setText(reviews.get(position).getContent());
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onReviewItemClick(clickedPosition);
        }
    }
}
