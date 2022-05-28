package com.example.singletonpatternroomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ContactModel::class], version=4)
abstract class ContactDatabase:RoomDatabase() {

    abstract fun contactDao() : ContactDAO

}