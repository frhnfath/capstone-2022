package com.dicoding.githubusersub3.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dicoding.githubusersub3.R;
import com.dicoding.githubusersub3.adapter.FavoriteAdapter;
import com.dicoding.githubusersub3.data.User;
import com.dicoding.githubusersub3.database.UserHelper;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {

    private UserHelper userHelper;
    private ArrayList<User> userList = new ArrayList<>();
    private FavoriteAdapter favoriteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        userHelper = new UserHelper(getApplicationContext());
        userHelper.open();
        userList = userHelper.getDataUser();
        setRecyclerView();
        if (getActionBar() != null) {
            getActionBar().hide();
        }
    }

    private void setRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.rv_fav);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        favoriteAdapter = new FavoriteAdapter(getApplication());
        recyclerView.setAdapter(favoriteAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        userList = userHelper.getDataUser();
        favoriteAdapter.setUserGithubList(userList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userHelper.close();
    }
}