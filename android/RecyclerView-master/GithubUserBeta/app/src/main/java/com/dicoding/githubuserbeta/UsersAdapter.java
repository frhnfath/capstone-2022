package com.dicoding.githubuserbeta;

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

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {
    private ArrayList<Users> mData = new ArrayList<>();
    private OnItemClickCallback onItemClickCallback;

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Users data);
    }

    void setData(ArrayList<Users> items) {
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsersAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_items, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.UserViewHolder holder, int position) {
        holder.setItem(mData.get(position));
        holder.itemView.setOnClickListener(view -> onItemClickCallback.onItemClicked(mData.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_username) TextView username;
        @BindView(R.id.tv_htmlUrl) TextView html_url;
        @BindView(R.id.img_avatar) ImageView avatar;

        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setItem(Users item) {
            html_url.setText(item.getHtmlUrl());
            username.setText(item.getUsername());
            Picasso.get()
                    .load(item.getAvatar())
                    .resize(100,100)
                    .centerCrop()
                    .into(avatar);
        }
    }
}

