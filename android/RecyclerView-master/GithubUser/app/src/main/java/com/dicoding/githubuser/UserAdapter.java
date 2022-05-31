package com.dicoding.githubuser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.githubuser.R;
import com.dicoding.githubuser.User;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> users = new ArrayList<>();

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public UserAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.activity_user_item, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        User user = (User) getItem(i);
        viewHolder.bind(user);
        return itemView;
    }

    private class ViewHolder {
        private TextView tvUsername, tvName;
        private ImageView imgAvatar;

        ViewHolder(View view) {
            tvUsername = view.findViewById(R.id.tv_username);
            tvName = view.findViewById(R.id.tv_name);
            imgAvatar = view.findViewById(R.id.img_avatar);
        }

        void bind(User user) {
            tvUsername.setText(user.getUsername());
            tvName.setText(user.getName());

            int imageResource = context.getResources().getIdentifier(user.getAvatar(), "drawable", context.getPackageName());

            Glide.with(context)
                    .load(imageResource)
                    .apply(new RequestOptions().override(55, 55))
                    .into(imgAvatar);
        }
    }
}
