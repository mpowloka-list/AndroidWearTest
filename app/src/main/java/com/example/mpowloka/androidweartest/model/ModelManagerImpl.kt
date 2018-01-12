package com.example.mpowloka.androidweartest.model

import android.content.Context
import com.example.mpowloka.androidweartest.model.interfaces.CitiesProvider
import com.example.mpowloka.androidweartest.model.interfaces.ItemsProvider
import com.example.mpowloka.androidweartest.model.interfaces.ModelManager
import com.example.mpowloka.androidweartest.model.interfaces.PersonsProvider
import com.example.mpowloka.androidweartest.model.persistence.ListonicDatabase

/**
 * Created in Listonic by mpowloka on 12.01.2018.
 */

class ModelManagerImpl(database: ListonicDatabase) : ModelManager {

    override val personsProvider: PersonsProvider = database.personDao

    override val itemsProvider: ItemsProvider = database.itemDao

    override val citiesProvider: CitiesProvider = database.cityDao


    companion object {
        private var INSTANCE: ModelManager? = null

        fun getInstance(context: Context): ModelManager {
            if (INSTANCE == null) {
                INSTANCE = ModelManagerImpl(
                        ListonicDatabase.getDatabase(context)
                )
            }
            return INSTANCE!!
        }
    }
}