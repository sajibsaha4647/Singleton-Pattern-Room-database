package com.example.singletonpatternroomdatabase

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

import java.util.*

@Database(entities = [ContactModel::class], version = 2)
@TypeConverters(Converters::class)
abstract class ContactDatabase:RoomDatabase() {

    abstract fun contactDao() : ContactDAO
    companion object {

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLLUM age INTEGER NOT NULL DEFAULT(0)")
            }
        }

        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context):ContactDatabase{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,ContactDatabase::class.java,"Simple.db")
                        .fallbackToDestructiveMigration()
//                        .addMigrations(MIGRATION_1_2)
                        .build()
                }
            }
            return  INSTANCE!!
        }
    }

}