package com.example.mpowloka.androidweartest.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

@Database(
        entities = [Person::class, Item::class, City::class],
        version = 1
)
abstract class ListonicDatabase : RoomDatabase(){
}