package com.dicoding.mymoviecatalogue.series

import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.mymoviecatalogue.utils.MarginDecoration
import com.dicoding.mymoviecatalogue.databinding.FragmentSeriesBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [SeriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SeriesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var fragmentSeriesBinding: FragmentSeriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentSeriesBinding = FragmentSeriesBinding.inflate(layoutInflater, container, false)
        return fragmentSeriesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[SeriesViewModel::class.java]
            val series = viewModel.getSeries()
            val seriesAdapter = SeriesAdapter()
            seriesAdapter.setSeries(series)
            val verticalMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics)
            with(fragmentSeriesBinding.rvSeries) {
                addItemDecoration(MarginDecoration(verticalMargin.toInt()))
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = seriesAdapter
            }
        }
    }
}