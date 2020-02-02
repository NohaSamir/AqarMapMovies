package com.example.basemasterdetailsapplication

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.basemasterdetailsapplication.data.source.database.AppDatabase
import com.example.basemasterdetailsapplication.data.source.database.MovieDao
import com.example.basemasterdetailsapplication.data.source.database.models.DatabaseMovie
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var movieDao: MovieDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()

        movieDao = db.movieDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {

        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetData() {
        val item = DatabaseMovie("1", 10.0, "test", "")
        val list: Array<DatabaseMovie> = listOf(item).toTypedArray()
        movieDao.insert(*list)
        val allData = movieDao.getAllData()
        assertEquals(allData.value?.size, 1)
    }
}