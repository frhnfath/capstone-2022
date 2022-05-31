package com.frhnfath.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail Page"

        val data = intent.getParcelableExtra<User>("DATA")
        Log.d("Data Detail", data?.following.toString())
        Log.d("Data Detail 2", data?.username.toString())

        val detailPhoto: ImageView = findViewById(R.id.img_detail)
        val tvDetailUsername: TextView = findViewById(R.id.tv_detail_username)
        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvRepository: TextView = findViewById(R.id.repository_number)
        val tvFollowing: TextView = findViewById(R.id.following_number)
        val tvFollowers: TextView = findViewById(R.id.followers_number)
        val tvLocation: TextView = findViewById(R.id.location_info)
        val tvCompany: TextView = findViewById(R.id.company_info)

        if (data != null) {
            detailPhoto.setImageResource(data.photo)
            tvDetailUsername.setText(data.username)
            tvDetailName.setText(data.name)
            tvRepository.setText(data.repository.toString())
            tvFollowing.setText(data.following.toString())
            tvFollowers.setText(data.followers.toString())
            tvLocation.setText(data.location)
            tvCompany.setText(data.company)
        }
    }

}