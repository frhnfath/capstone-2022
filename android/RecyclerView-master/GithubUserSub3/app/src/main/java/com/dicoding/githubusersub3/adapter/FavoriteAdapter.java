package com.dicoding.githubusersub3.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dicoding.githubusersub3.R;
import com.dicoding.githubusersub3.data.User;
import com.dicoding.githubusersub3.layout.DetailActivity;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.UserViewHolder> {
    private Context c;
    private ArrayList<User> user ;

    public FavoriteAdapter(Context c) {
        this.c = c;
    }

    public void setUserGithubList(ArrayList<User> userGithubArrayList){
        this.user = userGithubArrayList;
    }

    @NonNull
    @Override
    public FavoriteAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_users,parent,false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.UserViewHolder holder, int position) {
        User users = user.get(position);
        holder.tv_name.setText(users.getLogin());
        holder.tv_url.setText(users.getHtmlUrl());
        Glide.with(holder.itemView.getContext())
                .load(users.getAvatarUrl())
                .into(holder.img);


    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView tv_url,tv_name;
        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_avatar);
            tv_name = itemView.findViewById(R.id.tv_username);
            tv_url = itemView.findViewById(R.id.tv_htmlUrl);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            User userGithub = user.get(getAdapterPosition());
            Intent intent = new Intent(c, DetailActivity.class);
            intent.putExtra("DATA_USER",userGithub);
            v.getContext().startActivity(intent);
        }
    }
}
