package com.dicoding.mymoviecatalogue.movie

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.mymoviecatalogue.databinding.FragmentMovieBinding
import com.dicoding.mymoviecatalogue.utils.MarginDecoration

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [MovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
            val mvs = viewModel.getMovies()
            val movieAdapter = MovieAdapter()
            movieAdapter.setMovies(mvs)
            val verticalMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics)

            with(fragmentMovieBinding.rvFilm) {
                addItemDecoration(MarginDecoration(verticalMargin.toInt()))
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MovieFragment.
         */
    }
}