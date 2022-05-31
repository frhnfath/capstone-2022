package com.dicoding.githubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailUser extends AppCompatActivity {

    public static final String EXTRA_USER = "extra_user";
    private TextView username, name, location, company, following, follower, repository;
    private ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        parcelLayout();

        User user= getIntent().getParcelableExtra(EXTRA_USER);

        if (user != null) {
            username.setText(user.getUsername());
            name.setText(user.getName());
            company.setText(user.getLocation());
            location.setText(user.getLocation());
            repository.setText(user.getRepository());
            follower.setText(user.getFollower());
            following.setText(user.getFollowing());

            int imageResource = this.getResources().getIdentifier(user.getAvatar(), "drawable", this.getPackageName());

            Glide.with(this)
                    .load(imageResource)
                    .apply(new RequestOptions().override(100,100))
                    .into(avatar);
        }
    }

    private void parcelLayout() {
        username =findViewById(R.id.tv_detail_username);
        name = findViewById(R.id.tv_detail_name);
        company = findViewById(R.id.tv_detail_company);
        location = findViewById(R.id.tv_detail_location);
        avatar = findViewById(R.id.img_detail_avatar);
        following = findViewById(R.id.tv_detail_following);
        follower = findViewById(R.id.tv_detail_follower);
        repository = findViewById(R.id.tv_detail_repository);
    }
}