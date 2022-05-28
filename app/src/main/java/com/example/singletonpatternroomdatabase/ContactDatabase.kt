package com.example.singletonpatternroomdatabase

import android.content.Context
import androidx.room.*

@Database(entities = [ContactModel::class], version=4)
@TypeConverters(Converters::class)
abstract class ContactDatabase:RoomDatabase() {

    abstract fun contactDao() : ContactDAO

    companion object {

        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context):ContactDatabase{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,ContactDatabase::class.java,"Simple.db").fallbackToDestructiveMigration().build()
                }
            }
            return  INSTANCE!!
        }
    }

}