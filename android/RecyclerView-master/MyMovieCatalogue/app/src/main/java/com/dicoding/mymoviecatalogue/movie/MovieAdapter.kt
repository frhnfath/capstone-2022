package com.dicoding.mymoviecatalogue.movie

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
import com.dicoding.mymoviecatalogue.DetailModel.Companion.MOVIE
import com.dicoding.mymoviecatalogue.R

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var mvs = ArrayList<MovieEntity>()
    class MovieViewHolder (private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mv: MovieEntity) {
            with(binding) {
                tvTitle.text = mv.title
                tvGenre.text = mv.genre
                Glide.with(itemView.context)
                    .load(mv.poster)
                    .transform(RoundedCorners(25))
                    .into(imgPoster)
                val bitmap = BitmapFactory.decodeResource(itemView.context.resources, mv.poster)
                Palette.from(bitmap).generate { palette ->
                    val defValue = itemView.resources.getColor(R.color.design_default_color_primary_dark, itemView.context.theme)
                    itemMovie.setCardBackgroundColor(palette?.getDarkMutedColor(defValue) ?: defValue)
                }
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, mv.id)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, MOVIE)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(mvs[position])
    }

    override fun getItemCount(): Int = mvs.size

    fun setMovies(mvs: ArrayList<MovieEntity>?) {
        if (mvs.isNullOrEmpty()) return
        this.mvs.clear()
        this.mvs.addAll(mvs)
    }
}