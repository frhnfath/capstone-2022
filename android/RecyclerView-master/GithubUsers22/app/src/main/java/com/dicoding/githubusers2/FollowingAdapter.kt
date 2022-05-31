package com.dicoding.githubusers2

import android.view.LayoutInflater
import android.widget.AdapterView
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView

var followingFilterList = ArrayList<UserData>()

class FollowingAdapter(listUser: ArrayList<UserData>) : RecyclerView.Adapter<FollowingAdapter.ListViewHolder>() {
    init {
        followingFilterList = listUser
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback)
}