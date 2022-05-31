package com.frhnfath.submssion2

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import com.frhnfath.submssion2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = _root_ide_package_.androidx.lifecycle.ViewModelProvider(this).get(MainViewModel::class.java)

        val btntest: Button = findViewById(R.id.btntest)
        btntest.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)

        val searchManager = getSystemService(SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView

        viewModel = _root_ide_package_.androidx.lifecycle.ViewModelProvider

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            // use this method if search is do
            override fun onQueryTextSubmit(query: String?): Boolean {
                findUser = query.toString()
                clearFocus()
                return true
            }

            // use this method to respond every change of letter on searchView
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        return true
    }

    override fun onClick(v: View) {
        when (v?.id) {
            R.id.btntest -> {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                startActivity(intent)
            }
        }
    }

}