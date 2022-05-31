package com.dicoding.githubuserfix.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.githubuserfix.R
import com.dicoding.githubuserfix.adapter.mcontext
import com.dicoding.githubuserfix.data.UserData
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.users_items.view.*

var followingFilterList = ArrayList<UserData>()

class FollowingAdapter(listUser: ArrayList<UserData>) : RecyclerView.Adapter<FollowingAdapter.ListViewHolder>() {
    init {
        followingFilterList = listUser
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.users_items, viewGroup, false)
        val sch = ListViewHolder(view)
        mcontext = viewGroup.context
        return sch
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = followingFilterList[position]
        Glide.with(holder.itemView.context)
            .load(data.avatar)
            .apply(RequestOptions().override(250, 250))
            .into(holder.imgAvatar)
        holder.txtUsername.text = data.username
        holder.txtName.text = data.name
        holder.txtCompany.text = data.company
        holder.txtLocation.text = data.location
        holder.itemView.setOnClickListener {
            //DO NOTHING
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(UserData: UserData)
    }

    override fun getItemCount(): Int = followingFilterList.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: CircleImageView = itemView.img_avatar
        var txtUsername: TextView = itemView.tv_username
        var txtName: TextView = itemView.tv_name
        var txtCompany: TextView = itemView.tv_company
        var txtLocation: TextView = itemView.tv_location
    }

}