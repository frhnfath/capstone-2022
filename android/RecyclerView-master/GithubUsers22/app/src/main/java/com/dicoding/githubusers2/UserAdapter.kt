package com.dicoding.githubusers2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*
import kotlin.collections.ArrayList

var userFilterList = ArrayList<UserData>()
lateinit var mContext: Context

class UserAdapter(private var listData: ArrayList<UserData>) : RecyclerView.Adapter<UserAdapter.ListViewHolder>(), Filterable {
    init {
        userFilterList= listData
    }

    private var onItemCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ListViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserAdapter.ListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }
}