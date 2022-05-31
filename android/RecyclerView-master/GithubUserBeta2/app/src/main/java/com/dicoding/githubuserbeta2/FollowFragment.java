package com.dicoding.githubuserbeta2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

public class FollowFragment extends Fragment {

    private String queryType, username;
    private RecyclerView rootView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FollowAdapter adapter = new FollowAdapter();
        rootView.setAdapter(adapter);
        DetailViewModel detailViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailViewModel.class);
        detailViewModel.fetchFollow(username, queryType);
        detailViewModel.getUsers().observe(getViewLifecycleOwner(), adapter::setData);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_follow, container, false);
        rootView = view.findViewById(R.id.recyclerViewFollow);
        rootView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL));
        assert getArguments() != null;
        username = getArguments().getString("username");
        queryType = getArguments().getString("query");
        return rootView;
    }
}