package com.example.daggerhilt.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daggerhilt.model.Data
import kotlinx.coroutines.flow.Flow

@Dao
interface DeliverDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: Data)

    @Query("SELECT * FROM tbData")
    fun fetchData(): Flow<List<Data>>
}