package com.example.singletonpatternroomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO {

    @Insert
    fun insertContacts(contacts:ContactModel){

    }

    @Update
    fun updateContacts(contacts: ContactModel){

    }

    @Delete
    fun deleteContact(contacts: ContactModel){

    }

    @Query("SELECT * FROM contacts")
    fun readContacts():LiveData<List<ContactModel>>


}