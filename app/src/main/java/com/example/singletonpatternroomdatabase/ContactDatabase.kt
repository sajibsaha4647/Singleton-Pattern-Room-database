package com.example.singletonpatternroomdatabase

import androidx.room.Database

@Database(entities = [ContactModel::class],version=1)
abstract class ContactDatabase {

    abstract fun contactDao() : ContactDAO

}