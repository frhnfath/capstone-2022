package com.frhnfath.githubuserapp.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.frhnfath.githubuserapp.R
import com.frhnfath.githubuserapp.adapter.SectionsPagerAdapter
import com.frhnfath.githubuserapp.databinding.ActivityDetailBinding
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    var isFavorite = false

    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = Bundle()

        supportActionBar?.elevation = 0f

        supportActionBar?.title = "Detail Page"

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            DetailViewModel::class.java)
        val username = intent.getStringExtra(EXTRA_USERNAME)
        bundle.putString(EXTRA_USERNAME, username)
        viewModel.setUser(username!!)
        viewModel.user.observe(this) {
            if (it != null) {
                binding.apply {
                    Glide.with(this@DetailActivity)
                        .load(it.avatar_url)
                        .into(imgDetail)
                    tvDetailName.text = it.name
                    tvDetailUsername.text = it.login
                    repositoryNumber.text = it.public_repos.toString()
                    companyInfo.text = it.company
                    locationInfo.text = it.location
                    followingNumber.text = it.following.toString()
                    followersNumber.text = it.followers.toString()
                }
            }
        }
        val viewPager = binding.viewPager
        val tabs = binding.tabs
        Log.d("Detail Activity", "onCreate: $bundle")
        val sectionsPagerAdapter = SectionsPagerAdapter(this, bundle)
        binding.apply {
            viewPager.adapter = sectionsPagerAdapter
        }
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        if (!isFavorite) {
            inflater.inflate(R.menu.options_menu, menu)
        }
        inflater.inflate(R.menu.activity_menu, menu)

        return true
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_COMPANY = "extra_company"
    }
}