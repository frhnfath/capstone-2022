package com.frhnfath.githubuserapp.activity

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.frhnfath.githubuserapp.R
import com.frhnfath.githubuserapp.adapter.UserAdapter
import com.frhnfath.githubuserapp.response.UserResponse
import com.frhnfath.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<UserResponse>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter()
        userAdapter.notifyDataSetChanged()
        userAdapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: UserResponse) {
                Intent(this@MainActivity, DetailActivity::class.java).also {
                    it.putExtra(DetailActivity.EXTRA_USERNAME, data.login)
                    it.putExtra(DetailActivity.EXTRA_NAME, data.name)
                    it.putExtra(DetailActivity.EXTRA_COMPANY, data.company)
                    showSelectedUser(data)
                    startActivity(it)
                }
            }

        })

        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)

        val searchView = menu.findItem(R.id.search).actionView as SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                showProgressBar(true)
                viewModel.searchUser(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                list.clear()
                return false
            }
        })
        return true
    }

    private fun showProgressBar(b: Boolean) {
        if (b)  {
            binding.progressBarMain.visibility = View.VISIBLE
        }
        else {
            binding.progressBarMain.visibility = View.GONE
        }
    }


    // create function to show recycler list
    private fun showRecyclerList() {
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            MainViewModel::class.java)
        binding.apply {
            rvUsers.layoutManager = LinearLayoutManager(this@MainActivity)
            rvUsers.setHasFixedSize(true)
            rvUsers.adapter = userAdapter
        }

        viewModel.getSearch().observe(this) { query ->
            if (query != null) {
                userAdapter.setList(query)
                showProgressBar(false)
            }
        }
    }


    fun showSelectedUser(user: UserResponse) {
        // create Toast to enable flash information to user
        Toast.makeText(this, "You choose " + user.login, Toast.LENGTH_SHORT).show()
    }
}