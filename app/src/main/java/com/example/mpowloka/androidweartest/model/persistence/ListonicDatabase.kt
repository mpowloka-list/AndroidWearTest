package com.example.mpowloka.androidweartest.model.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.mpowloka.androidweartest.model.persistence.dao.CityDao
import com.example.mpowloka.androidweartest.model.persistence.dao.ItemDao
import com.example.mpowloka.androidweartest.model.persistence.dao.PersonDao
import com.example.mpowloka.androidweartest.model.persistence.dao.PersonItemJoinDao
import com.example.mpowloka.androidweartest.model.persistence.migrations.MIGRATION_1_2

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

@Database(
        entities = [Person::class, Item::class, City::class, PersonItemJoin::class],
        version = 2
)
abstract class ListonicDatabase : RoomDatabase(){

    abstract val personDao: PersonDao
    abstract val cityDao: CityDao
    abstract val itemDao: ItemDao
    abstract val personItemJoinDao: PersonItemJoinDao

    companion object {
        private const val DB_NAME = "listonic_database"
        private val migrations = arrayOf(MIGRATION_1_2())
        private var INSTANCE: ListonicDatabase? = null

        fun getDatabase(context: Context): ListonicDatabase {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, ListonicDatabase::class.java, DB_NAME)
                        .addMigrations(*migrations)
                        .addCallback(LogsTableCreator)
                        .addCallback(TriggersInitializer)
                        .build()
            }
            return INSTANCE!!
        }


    }



}