package com.example.singletonpatternroomdatabase

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

import java.util.*

@Database(entities = [ContactModel::class], version=6)
@TypeConverters(Converters::class)
abstract class ContactDatabase:RoomDatabase() {

    abstract fun contactDao() : ContactDAO

    companion object {

        val MIGRATION_5_6 = object : Migration(5,6){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE 'contact' ADD COLLUM 'status' INTEGER NOT NULL DEFAULT(1)")

            }

        }

        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context):ContactDatabase{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,ContactDatabase::class.java,"Simple.db")
//                        .fallbackToDestructiveMigration()
                        .addMigrations(MIGRATION_5_6)
                        .build()
                }
            }
            return  INSTANCE!!
        }
    }

}