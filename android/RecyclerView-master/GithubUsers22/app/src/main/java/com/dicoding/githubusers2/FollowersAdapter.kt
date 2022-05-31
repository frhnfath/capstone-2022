package com.dicoding.githubusers2

import androidx.recyclerview.widget.RecyclerView

var followersFilterList = ArrayList<UserData>()

class FollowersAdapter(listUser: ArrayList<UserData>) : RecyclerView.Adapter<FollowersAdapter.ListViewHolder>()