package com.example.singletonpatternroomdatabase

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

import java.util.*

@Database(entities = [ContactModel::class], version = 3)
@TypeConverters(Converters::class)
abstract class ContactDatabase:RoomDatabase() {

    abstract fun contactDao() : ContactDAO
    companion object {

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                println("migration_1_2")
                database.execSQL("ALTER TABLE 'contact' ADD COLUMN 'age' INTEGER NOT NULL DEFAULT 0")

            }
        }

        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context):ContactDatabase{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,ContactDatabase::class.java,"Simple.db")
//                        .fallbackToDestructiveMigration()
                        .addMigrations(MIGRATION_2_3)
                        .build()
                }
            }
            return  INSTANCE!!
        }
    }

}