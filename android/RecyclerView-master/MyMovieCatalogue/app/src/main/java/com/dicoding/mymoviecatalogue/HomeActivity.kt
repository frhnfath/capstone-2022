package com.dicoding.mymoviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.mymoviecatalogue.movie.MovieFragment
import com.dicoding.mymoviecatalogue.series.SeriesFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setVPager()
    }

    private fun setVPager() {
        val titleTab = listOf("Movie", "Series")
        val listFragment = listOf(MovieFragment(), SeriesFragment())
        vpager.adapter = VPAdapter(listFragment, this.supportFragmentManager, lifecycle)
        TabLayoutMediator(tabLay, vpager){tab, position ->
            tab.text = titleTab[position]
        }.attach()
    }
}