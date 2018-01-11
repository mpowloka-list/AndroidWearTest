package com.example.mpowloka.androidweartest.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.mpowloka.androidweartest.model.dao.CityDao
import com.example.mpowloka.androidweartest.model.dao.ItemDao
import com.example.mpowloka.androidweartest.model.dao.PersonDao

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

@Database(
        entities = [Person::class, Item::class, City::class],
        version = 1,
        exportSchema = false
)
abstract class ListonicDatabase : RoomDatabase(){

    abstract val personDao: PersonDao
    abstract val cityDao: CityDao
    abstract val itemDao: ItemDao

    companion object {
        const val DB_NAME = "listonic_database"
        var INSTANCE: ListonicDatabase? = null

        fun getDatabase(context: Context): ListonicDatabase {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, ListonicDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE!!
        }
    }

}