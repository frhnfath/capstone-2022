package com.dicoding.picodiploma.recyclerviewsubmission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPlayers;
    private ArrayList<Player> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPlayers = findViewById(R.id.rv_players);
        rvPlayers.setHasFixedSize(true);

        list.addAll(PlayerData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvPlayers.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(list);
        rvPlayers.setAdapter(listAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    public void Pindah(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }

}
