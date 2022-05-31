package com.dicoding.githubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private UserAdapter adapter;
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new UserAdapter(this);
        listView.setAdapter(adapter);
        assignItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User user = new User();
                user.setUsername(users.get(i).getUsername());
                user.setName(users.get(i).getName());
                user.setAvatar(users.get(i).getAvatar());
                user.setCompany(users.get(i).getCompany());
                user.setFollower(users.get(i).getFollower());
                user.setFollowing(users.get(i).getFollowing());
                user.setRepository(users.get(i).getRepository());
                user.setLocation(users.get(i).getLocation());

                Intent intent = new Intent(MainActivity.this, DetailUser.class); //intent to 2nd activity
                intent.putExtra(DetailUser.EXTRA_USER, user);
                startActivity(intent);
            }
        });
    }

    private String loadJSONFromAsset(Context context) {
        String json = null;

        try {
            InputStream is =context.getAssets().open("githubuser.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void assignItem() {     //initiating json file
        users = new ArrayList<>();

        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(this));
            JSONArray arr = obj.getJSONArray("users");

            for (int i = 0;  i <  arr.length(); i++) {
                JSONObject object = arr.getJSONObject(i);
                User user = new User();
                user.setUsername(object.getString("username"));
                user.setName(object.getString("name"));
                user.setLocation(object.getString("location"));
                user.setFollowing(object.getString("location"));
                user.setFollower(object.getString("follower"));
                user.setCompany(object.getString("company"));
                user.setAvatar(object.getString("avatar"));
                user.setRepository(object.getString("repository"));
                users.add(user);
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        adapter.setUsers(users);
    }


}