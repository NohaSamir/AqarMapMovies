package com.example.basemasterdetailsapplication.data.source.network

import com.example.basemasterdetailsapplication.data.source.network.models.MoviesResponse
import com.example.basemasterdetailsapplication.data.source.network.models.NetworkMovie
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

val apiServices: AppApiServices by lazy {
    retrofit.create(AppApiServices::class.java)
}

const val API_KEY = "e7201e72d293a8848ba2f49d145cbe94"

interface AppApiServices {

    @GET("discover/movie?sort_by=popularity.desc")
    fun getPopularMovies(@Query("api_key") apiKey: String): Deferred<MoviesResponse>
}