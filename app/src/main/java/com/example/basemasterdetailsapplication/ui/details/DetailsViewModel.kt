package com.example.basemasterdetailsapplication.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basemasterdetailsapplication.domain.Movie

class DetailsViewModel(private val movie: Movie) : ViewModel() {

    private val _selectedProperty = MutableLiveData<Movie>()

    // The external LiveData for the SelectedProperty
    val selectedProperty: LiveData<Movie>
        get() = _selectedProperty

    // Initialize the _selectedProperty MutableLiveData
    init {
        _selectedProperty.value = movie
    }
}


/**
 * Simple ViewModel factory that provides the DummyData details and context to the ViewModel.
 */
class DetailViewModelFactory(
    private val movie: Movie
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(movie) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
