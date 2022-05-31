package com.frhnfath.submssion2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter: RecyclerView.Adapter<UsersAdapter.ListViewHolder>() {

    private val listUser = ArrayList<UsersAdapter>()

    inner class ListViewHolder(private val view: ItemListUserBinding) : RecyclerView.ViewHolder(itemView) {
        fun bind(githubResponse: UsersAdapter) {
            view.apply
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size

}