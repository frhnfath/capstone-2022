package com.dicoding.githubusersub3.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dicoding.githubusersub3.R;
import com.dicoding.githubusersub3.fragment.FollowersFragment;
import com.dicoding.githubusersub3.fragment.FollowingFragment;

import java.util.Objects;

public class VPAdapter extends FragmentPagerAdapter {

    private final Context context;
    public VPAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new FollowersFragment();
                break;
            case 1:
                fragment = new FollowingFragment();
                break;
        }
        return Objects.requireNonNull(fragment);
    }


    private final int[] TAB_NAME = new int[]{
            R.string.tab_follower,
            R.string.tab_following
    };
    @Override
    public int getCount() {
        return 2;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getString(TAB_NAME[position]);
    }
}
