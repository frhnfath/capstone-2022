package com.dicoding.githubuserbeta2;

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

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private OnItemClickCallback onItemClickCallback;
    private ArrayList<User> mData = new ArrayList<>();

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    void setData(ArrayList<User> items) {
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        holder.setItem(mData.get(position));
        holder.itemView.setOnClickListener(view -> onItemClickCallback.onItemClicked(mData.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvUsername)
        TextView username;
        @BindView(R.id.listAvatar)
        ImageView avatar;
        @BindView(R.id.tvUrl) TextView html_url;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setItem(User item) {
            html_url.setText(item.getHtmlUrl());
            username.setText(item.getUsername());
            Picasso.get()
                    .load(item.getAvatar())
                    .resize(100, 100)
                    .centerCrop()
                    .into(avatar);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(User data);
    }
}
