package com.example.basemasterdetailsapplication.data.source.network.models

import com.example.basemasterdetailsapplication.data.source.database.models.DatabaseMovie
import com.example.basemasterdetailsapplication.domain.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NetworkMovie(
    val id: String,
    @Json(name = "original_title")
    val title: String,
    @Json(name = "poster_path")
    val posterImage: String,
    @Json(name = "backdrop_path")
    val backdropImage: String

)

fun List<NetworkMovie>.asDomainModel(): List<Movie> {
    return map {

        Movie(
            id = it.id,
            title = it.title,
            posterImage = it.posterImage,
            backdropImage = it.backdropImage

        )
    }
}

fun List<NetworkMovie>.asDatabaseModel(): Array<DatabaseMovie> {
    return map {

        DatabaseMovie(
            id = it.id,
            title = it.title,
            posterImage = it.posterImage,
            backdropImage = it.backdropImage
        )
    }.toTypedArray()
}