package com.dicoding.githubuserfix.layout

import android.database.ContentObserver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.githubuserfix.R
import com.dicoding.githubuserfix.adapter.FavoriteAdapter
import com.dicoding.githubuserfix.data.FavoriteData
import com.dicoding.githubuserfix.database.DbContract.FavColumns.Companion.CONTENT_URI
import com.dicoding.githubuserfix.helper.MappingHelper
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        setActionBarTitle()
        rvFavorite.layoutManager = LinearLayoutManager(this)
        rvFavorite.setHasFixedSize(true)
        adapter = FavoriteAdapter(this)
        rvFavorite.adapter = adapter
        val handlerThread = HandlerThread("DataObserver")
        handlerThread.start()
        val handler = Handler(handlerThread.looper)
        val myObserver = object : ContentObserver(handler) {
            override fun onChange(self: Boolean) {
                loadNotesAsync()
            }
        }
        contentResolver.registerContentObserver(CONTENT_URI, true, myObserver)
        if (savedInstanceState == null) {
            loadNotesAsync()
        } else {
            val list = savedInstanceState.getParcelableArrayList<FavoriteData>(EXTRA_STATE)
            if (list != null) {
                adapter.listFavorite = list
            }
        }
    }

    private fun loadNotesAsync() {
        GlobalScope.launch(Dispatchers.Main) {
            progressBarFavorite.visibility = View.VISIBLE
            val defNotes = async(Dispatchers.IO) {
                val cursor = contentResolver?.query(CONTENT_URI, null, null, null, null)
                MappingHelper.mapCursorToArrayList(cursor)
            }
            val favoriteData = defNotes.await()
            progressBarFavorite.visibility = View.INVISIBLE
            if (favoriteData.size > 0) {
                adapter.listFavorite = favoriteData
            } else {
                adapter.listFavorite = ArrayList()
                showMessage()
            }
        }
    }

    private fun showMessage() {
        Toast.makeText(this, getString(R.string.empty_favorite), Toast.LENGTH_SHORT).show()
    }

    private fun setActionBarTitle() {
        if (supportActionBar != null) {
            supportActionBar?.title = "Favorite Users"
        }
    }

    override fun onResume() {
        super.onResume()
        loadNotesAsync()
    }

    private lateinit var adapter: FavoriteAdapter

    companion object {
        private const val EXTRA_STATE = "extra_state"
    }
}