
package com.dicoding.githubusers2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private var listData: ArrayList<UserData> = ArrayList()
    private lateinit var adapter: UserAdapter

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Github User's Search"
        adapter = UserAdapter(listData)
        recyclerViewConfig()
        searchUser()
        getUser()
    }

    private fun recyclerViewConfig() {
        recycleView.Lay
    }

    private fun getUser() {
        progressBar.visibility = View.VISIBLE
        val client = AsyncHttpClient()
        client.addHeader("User_Agent", "request")
        client.addHeader("Authorization", "token 4c5b087d8f967fdfda3cbc967eca7ae13c33428d")
        val url ="https://api.github.com/users"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                progressBar.visibility = View.INVISIBLE
                val result = String(responseBody)
                Log.d(TAG, result)
                try {
                    val jsonArray = JSONArray(result)
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val username: String = jsonObject.getString("login")
                        getUserDetail(username)
                    }
                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT)
                            .show()
                    e.printStackTrace()
                }
            }

            override fun onFailure(
                    statusCode: Int,
                    headers: Array<Header>,
                    responseBody: ByteArray,
                    error: Throwable
            ) {
                progressBar.visibility = View.INVISIBLE
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_LONG)
                        .show()
            }
        })
    }

    private fun getUserDetail(id: String) {

    }

    private fun searchUser() {
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (query.isEmpty()) return true
                else {
                    listData.clear()
                    getUserSearch(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }
}