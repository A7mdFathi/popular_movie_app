package com.example.android.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.movieapp.activity.DetailActivity;
import com.example.android.movieapp.R;
import com.example.android.movieapp.model.Movie;

import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ahmed on 04/09/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private static final String TAG = MovieAdapter.class.getSimpleName();

    final private ListItemClickListener mOnClickListener;

    List<Movie> movies;

    public MovieAdapter(List<Movie> movies, ListItemClickListener mOnClickListener) {
        this.movies = movies;
        this.mOnClickListener = mOnClickListener;

    }

    public void setMovieList(List<Movie> movieList) {
        movies.clear();
        movies = movieList;
        notifyDataSetChanged();
    }


    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layout = R.layout.movie_card;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder holder, int position) {

        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {


        @BindView(R.id.title_card)
        TextView title;
        @BindView(R.id.userrating_card)
        TextView userRating;
        @BindView(R.id.thumbnail)
        ImageView thumbnail;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);


        }

        void bind(int pos) {
            title.setText(movies.get(pos).getOriginalTitle());
            userRating.setText(movies.get(pos).getVoteAverage());

            String baseImageUrl = "http://image.tmdb.org/t/p/w500";
            String poster = baseImageUrl + movies.get(pos).getPosterPath();
            Glide.with(itemView.getContext())
                    .load(poster)
                    .into(thumbnail);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
