package com.frhnfath.githubuserssearch.activity

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import com.frhnfath.githubuserssearch.R

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMove: Button = findViewById(R.id.test_button)
        btnMove.setOnClickListener(this)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = findViewById<SearchView>(R.id.search_view)

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@MainActivity, query, Toast.LENGTH_SHORT).show()
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.test_button -> {
                val moveIntent = Intent(this@MainActivity, DetailActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}