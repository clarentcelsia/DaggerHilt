package com.example.daggerhilt.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbData")
data class Data(
    val name: String,
    val contact: String,
    val email: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
