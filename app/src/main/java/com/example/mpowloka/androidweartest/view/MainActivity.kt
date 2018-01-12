package com.example.mpowloka.androidweartest.view

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.util.Log
import com.example.mpowloka.androidweartest.R
import com.example.mpowloka.androidweartest.model.ModelManagerImpl
import com.example.mpowloka.androidweartest.model.persistence.City
import com.example.mpowloka.androidweartest.model.persistence.Item
import com.example.mpowloka.androidweartest.model.persistence.Person

class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAmbientEnabled()

        val modelManager = ModelManagerImpl.getInstance(this.applicationContext)

        //Dummy data
        val michal = Person(id = 1, name = "Michal", surname = "Powloka", age = 21, cityId = 1)
        val hook = Item(id = 1, name = "Grappling hook", price = 42.50)
        val lodz = City(id = 1, name = "Lodz")

        modelManager.citiesProvider.insert(lodz)
        modelManager.personsProvider.insert(michal)
        modelManager.itemsProvider.insert(hook)
        modelManager.personsProvider.addItemsToPerson(michal, hook)

        Log.i(TAG,"""
            ${modelManager.personsProvider.getAll()},
            ${modelManager.citiesProvider.getAll()},
            ${modelManager.itemsProvider.getAll()}
        """.trimIndent())

    }

    companion object {
        const val TAG = "MainActivity"
    }
}
