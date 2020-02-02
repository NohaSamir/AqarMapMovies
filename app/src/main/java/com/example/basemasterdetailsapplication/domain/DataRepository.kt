package com.example.basemasterdetailsapplication.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface DataRepository {

    fun getList(): LiveData<List<Movie>>

    suspend fun refreshList(dataStatus: MutableLiveData<DataStatus>?)
}