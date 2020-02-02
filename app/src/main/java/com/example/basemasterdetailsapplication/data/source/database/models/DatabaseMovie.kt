package com.example.basemasterdetailsapplication.data.source.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.basemasterdetailsapplication.domain.Movie


@Entity
data class DatabaseMovie(
    @PrimaryKey
    val id: String,
    val title: String,
    val posterImage: String,
    val backdropImage: String
)

fun List<DatabaseMovie>.asDomainModel(): List<Movie> {
    return map {

        Movie(
            id = it.id,
            title = it.title,
            posterImage = it.posterImage,
            backdropImage = it.backdropImage
        )
    }
}