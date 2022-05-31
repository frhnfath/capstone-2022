package com.dicoding.githubuserbeta;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FollowingAdapter extends RecyclerView.Adapter<FollowingAdapter.FollowViewHolder> {
    private ArrayList<Users> mData = new ArrayList<>();
    void setData(ArrayList<Users> items) {
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }

    FollowingAdapter() {
    }

    @NonNull
    @Override
    public FollowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_follow, parent, false);
        return new FollowViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowViewHolder holder, int position) {
        holder.setItem(mData.get(position));
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_USER, mData.get(position));
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class FollowViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.following_tv_username) TextView username;
        @BindView(R.id.following_tv_htmlUrl) TextView htmlUrl;
        @BindView(R.id.following_img_avatar) ImageView avatar;

        FollowViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setItem(Users item) {
            htmlUrl.setText(item.getHtmlUrl());
            username.setText(item.getUsername());
            Picasso.get()
                    .load(item.getAvatar())
                    .resize(100,100)
                    .centerCrop()
                    .into(avatar);
        }
    }
}