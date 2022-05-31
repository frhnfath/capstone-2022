package com.dicoding.githubusersub3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dicoding.githubusersub3.R;
import com.dicoding.githubusersub3.adapter.UserAdapter;
import com.dicoding.githubusersub3.api.Config;
import com.dicoding.githubusersub3.api.Service;
import com.dicoding.githubusersub3.data.User;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FollowingFragment} factory method to
 * create an instance of this fragment.
 */
public class FollowingFragment extends Fragment {


    private RecyclerView recyclerView;
    private ShimmerFrameLayout shimmerFrameLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_following, container, false);
        setDataFollowers(view);
        return view;
    }

    private void setDataFollowers(View view){
        recyclerView = view.findViewById(R.id.rv_user);
        shimmerFrameLayout = view.findViewById(R.id.shimmer_layout);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        User user = Objects.requireNonNull(getActivity()).getIntent().getParcelableExtra("DATA_USER");
        Service apiService = Config.getRetrofit().create(Service.class);
        Call<List<User>> call = apiService.getUserFollowing(Objects.requireNonNull(user).getLogin());
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                UserAdapter userAdapter = new UserAdapter(getContext(),response.body());
                recyclerView.setAdapter(userAdapter);
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}
