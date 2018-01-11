package com.example.mpowloka.androidweartest

import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import com.example.mpowloka.androidweartest.model.ListonicDatabase

class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAmbientEnabled()

        val database = Room.inMemoryDatabaseBuilder(this.applicationContext, ListonicDatabase::class.java)
    }
}
