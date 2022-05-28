package com.example.singletonpatternroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.singletonpatternroomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var database:ContactDatabase
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this, R.layout.activity_main)
//        database = Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"Simple.db").fallbackToDestructiveMigration().build()

        database = ContactDatabase.getDatabase(this)


        GlobalScope.launch {
            database.contactDao().insertContact(ContactModel(0,"bdtask new","s@gmail.com",Date(),1,"98787987",89))
            println("data save successfully")
        }



//        database.contactDao().readContact().observe(this, androidx.lifecycle.Observer {
//            println(it.toString())
//        })




    }




}