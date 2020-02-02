package com.example.basemasterdetailsapplication.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Movie(
    val id: String,
    val title: String,
    val posterImage: String,
    val backdropImage: String
) : Parcelable