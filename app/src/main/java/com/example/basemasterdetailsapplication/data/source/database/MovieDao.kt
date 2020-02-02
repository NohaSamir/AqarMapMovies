package com.example.basemasterdetailsapplication.data.source.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.basemasterdetailsapplication.data.source.database.models.DatabaseMovie

@Dao
interface MovieDao {

    @Query("Select * from DatabaseMovie")
    fun getAllData(): LiveData<List<DatabaseMovie>>

    @Query("Select * from DatabaseMovie where id = :key ")
    fun get(key: String): DatabaseMovie

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg list: DatabaseMovie)
}