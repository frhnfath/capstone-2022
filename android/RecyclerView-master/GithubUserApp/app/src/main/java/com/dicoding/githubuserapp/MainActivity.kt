package com.dicoding.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private var usernameGithub = resources.getStringArray(R.array.username)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView:ListView = findViewById(R.id.lv_list)
        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, android.R.id.text1, usernameGithub)
        listView.adapter = adapter
    }

}