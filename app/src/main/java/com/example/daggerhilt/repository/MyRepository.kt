package com.example.daggerhilt.repository

import com.example.daggerhilt.model.Data
import com.example.daggerhilt.room.DeliverDao
import javax.inject.Inject

/**
 * @Inject tells dagger that we want dagger provides an instance of
 * the inside of constructor to Repository.
 */
class MyRepository @Inject constructor(private val deliver: DeliverDao) {

    suspend fun insertData(data: Data) = deliver.insertData(data)

    fun fetchData() = deliver.fetchData()

}