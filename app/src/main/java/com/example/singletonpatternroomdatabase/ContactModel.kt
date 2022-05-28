package com.example.singletonpatternroomdatabase

import androidx.room.Entity

@Entity(tableName = "contacts")
data class ContactModel(
    val id:Long,
    val name:String,
    val email:String
)
