package com.dicoding.githubuser2;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.AppBarLayout;

import butterknife.BindView;

public class DetailActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {
    public static final String EXTRA_USER = "extra_user";
    private static final int PERCENTAGE_TO_ANIMATE_AVATAR = 20;
    private String userName;
    private boolean showAvatar = true;
    private int maxScrollSize;

    @BindView()

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (maxScrollSize ==0)
            maxScrollSize
    }
}
