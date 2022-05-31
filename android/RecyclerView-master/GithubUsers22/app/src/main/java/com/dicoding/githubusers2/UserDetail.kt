package com.dicoding.githubusers2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.annotation.SuppressLint

class UserDetail : AppCompatActivity() {

    companion object {const val EXTRA_DATA = "extra_data"}

    @SurpressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        setData()
        viewPagerConfig()
    }

    private fun viewPagerConfig() {
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithPageAdapter(view_pager)

        supportActionBar?.elevation = 0f
    }

    private fun setData() {
        val dataUser = intent.getParcelableExtra(EXTRA_DATA) as UserData
        dataUser.name?.let { setActionBarTitle(it) }
        detai
    }
}
