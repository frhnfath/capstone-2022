package com.frhnfath.submssion2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.frhnfath.submssion2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvUsers: RecyclerView
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var usersAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        usersAdapter = UsersAdapter()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        rvUsers = findViewById(R.id.rv_search)
        rvUsers.setHasFixedSize(true)

        val btnMove: Button = findViewById(R.id.test_button)
        btnMove.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.test_button -> {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                startActivity(intent)
            }
        }
    }
}