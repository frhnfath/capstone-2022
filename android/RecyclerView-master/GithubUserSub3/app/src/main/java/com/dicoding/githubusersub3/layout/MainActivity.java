package com.dicoding.githubusersub3.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.dicoding.githubusersub3.R;
import com.dicoding.githubusersub3.adapter.SearchAdapter;
import com.dicoding.githubusersub3.adapter.UserAdapter;
import com.dicoding.githubusersub3.api.Config;
import com.dicoding.githubusersub3.api.Service;
import com.dicoding.githubusersub3.data.SearchResponse;
import com.dicoding.githubusersub3.data.User;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        views();
        getUser();
    }


    private void getUser() {
        Service service = Config.getRetrofit().create(Service.class);
        Call<List<User>> call = service.getGithubUser("10d995868a5bfc2e27f807dd73d5a65ffeb5b0b4");
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.body() != null) {
                    UserAdapter userAdapter = new UserAdapter(getApplicationContext(), response.body());
                    recyclerView.setAdapter(userAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "data not loaded", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void views() {
        recyclerView = findViewById(R.id.recycler_view);
        searchView = findViewById(R.id.main_search_username);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                getSearch(newText);
                return false;
            }
        });
    }

    private void getSearch(String username) {
        Service service = Config.getRetrofit().create(Service.class);
        Call<SearchResponse> call = service.getGithubSearch(username);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if (response.body() != null) {
                    SearchAdapter searchAdapter = new SearchAdapter(response.body().getItems());
                    recyclerView.setAdapter(searchAdapter);
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "data not loaded", Toast.LENGTH_SHORT).show();
            }
        });
    }
}