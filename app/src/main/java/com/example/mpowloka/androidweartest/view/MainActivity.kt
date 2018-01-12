package com.example.mpowloka.androidweartest.view

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import com.example.mpowloka.androidweartest.R
import com.example.mpowloka.androidweartest.model.ModelManagerImpl

class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAmbientEnabled()

        val modelManager = ModelManagerImpl.getInstance(this.applicationContext)

    }

    companion object {
        const val TAG = "MainActivity"
    }
}
