package com.dicoding.githubuser2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FollowingAdapter extends RecyclerView.Adapter<FollowingAdapter.FollowingViewHolder> {
    private ArrayList<User> mData = new ArrayList<>();

    void setData(ArrayList<User> items) {
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }

    FollowingAdapter() {
    }

    static class FollowingViewHolder extends RecyclerView.ViewHolder {
        @BindView
    }

    @NonNull
    @Override
    public FollowingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_following, parent, false);
        return new FollowingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowingViewHolder holder, int position) {
        holder.setItem(mData.get(position));
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_USER)
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class FollowingViewHolder extends RecyclerView.ViewHolder {
    }
}
