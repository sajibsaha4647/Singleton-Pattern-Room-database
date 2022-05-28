package com.example.singletonpatternroomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "contact")
data class ContactModel(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val name:String,
    val email:String,
    val createdate: Date,
    val isactive:Int,
    val phone:String,
    val age:Int
)
