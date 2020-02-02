package com.example.basemasterdetailsapplication.ui.details

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.basemasterdetailsapplication.R
import com.example.basemasterdetailsapplication.databinding.DetailsFragmentBinding
import com.example.basemasterdetailsapplication.domain.Movie


class DetailsFragment : DialogFragment() {

    private lateinit var viewModel: DetailsViewModel

    companion object {

        private const val MOVIE = "movie"

        @JvmStatic
        fun newInstance(movie: Movie) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MOVIE, movie)
                }
            }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DetailsFragmentBinding.inflate(inflater)


        val movie: Movie = arguments?.get(MOVIE) as Movie
        val viewModelFactory = DetailViewModelFactory(movie = movie)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailsViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        // Set transparent background and no title
        dialog?.let { it ->
            it.window?.let {
                it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                it.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        }


    }


    override fun onActivityCreated(arg0: Bundle?) {
        super.onActivityCreated(arg0)

        dialog?.let {
            it.window?.let {
                it.getAttributes().windowAnimations = R.style.DialogStyle
            }
        }
    }
}
