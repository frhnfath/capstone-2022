package com.frhnfath.githubuserapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

    // create function to show recycler list
    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUsers.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUsers.layoutManager = LinearLayoutManager(this)
        }
        val listUserAdapter = ListUserAdapter(list)
        rvUsers.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(user: User) {
                showSelectedUser(user)
                val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
                detailIntent.putExtra("DATA", user)
                startActivity(detailIntent)
            }
        })
    }

    // create function to assign data to be bind in Adapter
    private val listUsers: ArrayList<User>
        get() {
            val dataUsername = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val listUser = ArrayList<User>()
            for (i in dataUsername.indices) {
                val user = User(dataUsername[i], dataName[i], dataCompany[i], dataPhoto.getResourceId(i, -1),
                    dataFollowing[i], dataFollowers[i], dataLocation[i], dataRepository[i])
                listUser.add(user)
            }
            return listUser
        }

    fun showSelectedUser(user: User) {
        // create Toast to enable flash information to user
        Toast.makeText(this, "You choose " + user.username, Toast.LENGTH_SHORT).show()
    }
}