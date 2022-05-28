package com.example.singletonpatternroomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO {

    @Insert
    suspend fun insertContact(contacts:ContactModel)

    @Update
    suspend fun updateContact(contacts:ContactModel)

    @Delete
    suspend fun deleteContact(contacts:ContactModel)

    @Query("SELECT * FROM contact")
    fun readContact():LiveData <List<ContactModel>>





}