package com.example.daggerhilt.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daggerhilt.model.Data

@Database(entities = [Data::class], version = 1, exportSchema = false)
abstract class Db: RoomDatabase(){

    abstract fun deliver(): DeliverDao
}