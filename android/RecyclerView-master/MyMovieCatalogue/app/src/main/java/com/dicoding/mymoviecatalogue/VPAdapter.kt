package com.dicoding.mymoviecatalogue

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class VPAdapter(private val fragmentList: List<Fragment>, fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun createFragment(position: Int): Fragment = fragmentList[position]

    override fun getItemCount(): Int = fragmentList.size
}