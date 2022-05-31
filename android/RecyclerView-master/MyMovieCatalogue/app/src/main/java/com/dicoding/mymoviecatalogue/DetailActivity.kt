package com.dicoding.mymoviecatalogue

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.dicoding.mymoviecatalogue.data.MovieEntity
import com.dicoding.mymoviecatalogue.databinding.ActivityDetailBinding
import com.dicoding.mymoviecatalogue.databinding.ItemMovieBinding
import com.google.android.material.appbar.AppBarLayout
import java.lang.Math.abs
import java.lang.StringBuilder

class DetailActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {
    private lateinit var detailBinding: ActivityDetailBinding
    private val percentage = 20
    private var mMaxScroll = 0
    private var mImageHidden = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        supportActionBar?.hide()
        detailBinding.toolbar.setNavigationOnClickListener { onBackPressed() }
        detailBinding.appbar.addOnOffsetChangedListener(this)
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailModel::class.java]
        val extras = intent.extras
        if (extras != null) {
            val dataId = extras.getString(EXTRA_MOVIE)
            val dataCategory = extras.getString(EXTRA_CATEGORY)
            if (dataId != null && dataCategory != null) {
                viewModel.setMovie(dataId, dataCategory)
                val movie= viewModel.getMovieDetail()
                pupulateDetail(movie)
            }
        }
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
            if (mMaxScroll == 0) mMaxScroll = appBarLayout!!.totalScrollRange

            val currentScrollPercentage: Int = (kotlin.math.abs(verticalOffset) * 100 / mMaxScroll)

            if (currentScrollPercentage >= percentage) {
                if (!mImageHidden) {
                    mImageHidden = true
                }
            }

            if (currentScrollPercentage < percentage) {
                if (mImageHidden) {
                    mImageHidden = false
                }
            }
        }

    private fun pupulateDetail(data: MovieEntity) {
        detailBinding.detailTvGenreDuration.text = StringBuilder("${data.genre} | ${data.duration}")
        detailBinding.collaps.title = data.title
        detailBinding.detailTvOverview.text = data.overview
        Glide.with(this)
            .load(data.poster)
            .into(detailBinding.imgDetail)
        detailBinding.imgDetail.tag = data.poster
        setColorByPalette(data.poster)
    }

    private fun setColorByPalette(poster: Int) {
        val bitmap = BitmapFactory.decodeResource(resources, poster)
        Palette.from(bitmap).generate { palette ->
            val defValue = resources.getColor(R.color.design_default_color_primary_dark, theme)
            detailBinding.detailCard.setCardBackgroundColor( palette?.getDarkMutedColor(defValue) ?: defValue)
            detailBinding.collaps.setContentScrimColor( palette?.getDarkMutedColor(defValue) ?: defValue)
            window.statusBarColor = palette?.getDarkMutedColor(defValue) ?: defValue
        }
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_CATEGORY = "extra_category"
    }


}