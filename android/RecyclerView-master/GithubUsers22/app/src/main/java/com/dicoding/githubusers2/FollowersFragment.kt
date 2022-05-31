package com.dicoding.githubusers2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header

class FollowersFragment : Fragment() {

    companion object {
        private val TAG = FollowersAdapter::class.java.simpleName
        const val EXTRA_DATA = "extra_data"
    }

    private var listUser: ArrayList<UserData> = ArrayList()
    private lateinit var adapter: FollowersAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_followers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FollowersAdapter(listUser)
        listUser.clear()
        val dataUser = activity!!.intent.getParcelableExtra(EXTRA_DATA) as UserData
        getUserFollowers(dataUser.username.toString())
    }

    private fun getUserFollowers(id: String) {
        progressBarFollowers.visibility = View.VISIBLE
        val client = AsynctHttpClient()
        client.addHeader("User-Agent", "request")
        client.addHeader("Authorization", "token 4c5b087d8f967fdfda3cbc967eca7ae13c33428d")
        val url = "https://api.github.com/users/$id/followers"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                TODO("Not yet implemented")
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }
}