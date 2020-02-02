package com.example.basemasterdetailsapplication.data.source.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesResponse(
    val results: List<NetworkMovie>
)