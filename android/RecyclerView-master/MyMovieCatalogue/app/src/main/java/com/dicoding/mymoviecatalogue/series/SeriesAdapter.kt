package com.dicoding.mymoviecatalogue.series

import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.mymoviecatalogue.data.MovieEntity
import com.dicoding.mymoviecatalogue.databinding.ItemMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.dicoding.mymoviecatalogue.DetailActivity
import com.dicoding.mymoviecatalogue.DetailModel.Companion.SERIES
import com.dicoding.mymoviecatalogue.R

class SeriesAdapter: RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>() {
    private var series = ArrayList<MovieEntity>()

    class SeriesViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(series: MovieEntity) {
            with (binding) {
                tvTitle.text = series.title
                tvGenre.text = series.genre
                Glide.with(binding.root.context)
                    .load(series.poster)
                    .transform(RoundedCorners(30))
                    .into(imgPoster)
                val bitmap = BitmapFactory.decodeResource(itemView.context.resources, series.poster)
                Palette.from(bitmap).generate { palette ->
                    val defValue = itemView.resources.getColor(R.color.design_default_color_primary_dark, itemView.context.theme)
                    itemMovie.setCardBackgroundColor(palette?.getDarkMutedColor(defValue) ?: defValue)
                }

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, series.id)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, SERIES)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeriesViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        holder.bind(series[position])
    }

    override fun getItemCount(): Int = series.size

    fun setSeries(series: ArrayList<MovieEntity>?) {
        if (series.isNullOrEmpty()) return
        this.series.clear()
        this.series.addAll(series)
    }
}