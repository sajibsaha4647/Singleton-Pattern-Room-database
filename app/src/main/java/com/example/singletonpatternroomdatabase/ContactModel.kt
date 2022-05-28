package com.example.singletonpatternroomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class ContactModel(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val name:String,
    val email:String
)
