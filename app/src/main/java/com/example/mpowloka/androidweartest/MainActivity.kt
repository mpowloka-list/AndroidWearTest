package com.example.mpowloka.androidweartest

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.util.Log
import com.example.mpowloka.androidweartest.model.persistence.City
import com.example.mpowloka.androidweartest.model.persistence.Item
import com.example.mpowloka.androidweartest.model.persistence.ListonicDatabase
import com.example.mpowloka.androidweartest.model.persistence.Person

class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAmbientEnabled()

        val database = ListonicDatabase.getDatabase(this.applicationContext)

        database.cityDao.insert(listOf(
                City(name = "Lodz"),
                City(name = "Salt Lake City"),
                City(name = "Moscow"))
        )

        database.personDao.insert(listOf(
                Person(name = "Michal", surname = "Powloka", age = 21),
                Person(name = "Bill", surname = "Cypher", age = 42, cityId = 3))
        )

        database.itemDao.insert(*arrayOf(
                Item(name = "Hammer", price = 42.toDouble()),
                Item(name = "Cake", price = 15.70)
        ))

        Log.i(TAG, database.cityDao.getAll().joinToString(separator = "\n"))
        Log.i(TAG, database.personDao.getAll().joinToString(separator = "\n"))
        Log.i(TAG, database.itemDao.getAll().joinToString(separator = "\n"))


    }

    companion object {
        const val TAG = "MainActivity"
    }
}
