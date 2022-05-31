package com.dicoding.githubuserfix.layout

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.githubuserfix.R
import com.dicoding.githubuserfix.adapter.PagerSectionAdapter
import com.dicoding.githubuserfix.data.FavoriteData
import com.dicoding.githubuserfix.data.UserData
import com.dicoding.githubuserfix.database.DbContract.FavColumns.Companion.AVATAR
import com.dicoding.githubuserfix.database.DbContract.FavColumns.Companion.COMPANY
import com.dicoding.githubuserfix.database.DbContract.FavColumns.Companion.CONTENT_URI
import com.dicoding.githubuserfix.database.DbContract.FavColumns.Companion.FAVORITE
import com.dicoding.githubuserfix.database.DbContract.FavColumns.Companion.LOCATION
import com.dicoding.githubuserfix.database.DbContract.FavColumns.Companion.NAME
import com.dicoding.githubuserfix.database.DbContract.FavColumns.Companion.REPOSITORY
import com.dicoding.githubuserfix.database.DbContract.FavColumns.Companion.USERNAME
import com.dicoding.githubuserfix.database.FavHelper
import com.dicoding.githubuserfix.notifications.NotificationBroadcast
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.users_items.*

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_FAV = "extra_data"
        const val EXTRA_NOTE = "extra_note"
        const val EXTRA_POSITION = "extra_position"
    }

    private var isFavorite = false
    private lateinit var gitHelper: FavHelper
    private var favorites: FavoriteData? = null
    private lateinit var imageAvatar: String

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        gitHelper = FavHelper().getInstance(applicationContext)
        gitHelper.open()

        favorites = intent.getParcelableExtra(EXTRA_NOTE)
        if (favorites != null) {
            setDataObject()
            isFavorite = true
            val checked: Int = R.drawable.baseline_favorite_black_18dp
            btnFavorite.setImageResource(checked)
        } else {
            setData()
        }

        viewPagerConfig()
        btnFavorite.setOnClickListener(this)
    }

    private fun viewPagerConfig() {
        val viewPagerDetailAdapter = PagerSectionAdapter(this, supportFragmentManager)
        view_pager.adapter = viewPagerDetailAdapter
        tabs.setupWithViewPager(view_pager)

        supportActionBar?.elevation = 0f
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            this.title = title
        }
    }

    @SuppressLint("SetTextI18n", "StringFormatInvalid")
    private fun setData() {
        val dataUser = intent.getParcelableExtra(EXTRA_DATA) as UserData
        dataUser.name?.let { setActionBarTitle(it) }
        tv_detail_name.text = dataUser.name
        tv_detail_username.text = dataUser.username
        tv_detail_company.text = getString(R.string.company, dataUser.company)
        tv_detail_company.text = getString(R.string.location, dataUser.location)
        tv_detail_blog.text = getString(R.string.repository, dataUser.repository)
        Glide.with(this)
                .load(dataUser.avatar)
                .into(detail_avatar)
        imageAvatar = dataUser.avatar.toString()
    }

    @SuppressLint("SetTextI18n")
    private fun setDataObject() {
        val favoriteUser = intent.getParcelableExtra(EXTRA_NOTE) as FavoriteData
        favoriteUser.name?.let { setActionBarTitle(it) }
        tv_detail_name.text = favoriteUser.name
        tv_detail_username.text = favoriteUser.username
        tv_detail_company.text = favoriteUser.company
        tv_detail_location.text = favoriteUser.location
        tv_detail_blog.text = favoriteUser.repository
        Glide.with(this)
                .load(favoriteUser.avatar)
                .into(detail_avatar)
        imageAvatar = favoriteUser.avatar.toString()
    }

    override fun onClick(view: View) {
        val checked: Int = R.drawable.baseline_favorite_black_18dp
        val unChecked: Int = R.drawable.baseline_favorite_border_black_18dp
        if (view.id == R.id.btnFavorite) {
            if (isFavorite) {
                gitHelper.deleteById(favorites?.username.toString())
                Toast.makeText(this, getString(R.string.delete), Toast.LENGTH_SHORT).show()
                btnFavorite.setImageResource(unChecked)
                isFavorite = false
            } else {
                val dataUsername = tv_detail_username.text.toString()
                val dataName = tv_detail_name.text.toString()
                val dataAvatar = imageAvatar
                val datacompany = tv_detail_company.text.toString()
                val dataLocation = tv_location.text.toString()
                val dataRepository = tv_detail_blog.text.toString()
                val dataFavorite = "1"

                val values = ContentValues()
                values.put(USERNAME, dataUsername)
                values.put(NAME, dataName)
                values.put(AVATAR, dataAvatar)
                values.put(COMPANY, datacompany)
                values.put(LOCATION, dataLocation)
                values.put(REPOSITORY, dataRepository)
                values.put(FAVORITE, dataFavorite)

                isFavorite = true
                contentResolver.insert(CONTENT_URI, values)
                Toast.makeText(this, getString(R.string.fav_success_add), Toast.LENGTH_SHORT).show()
                btnFavorite.setImageResource(checked)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        gitHelper.close()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_language -> {
                val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
                startActivity(mIntent)
            }
            R.id.menu_notification -> {
                val mIntent = Intent(this, NotificationBroadcast::class.java)
                startActivity(mIntent)
            }
            R.id.menu_favorite -> {
                val mIntent = Intent(this, FavoriteActivity::class.java)
                startActivity(mIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}