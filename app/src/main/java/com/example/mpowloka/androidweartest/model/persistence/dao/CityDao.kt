package com.example.mpowloka.androidweartest.model.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.mpowloka.androidweartest.model.interfaces.CitiesProvider
import com.example.mpowloka.androidweartest.model.persistence.City
import com.example.mpowloka.androidweartest.model.persistence.dao.BaseDao

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

@Dao
abstract class CityDao : BaseDao<City>(), CitiesProvider {

    @Query (value = "SELECT * FROM $TABLE_NAME")
    override abstract fun getAll(): List<City>

    @Query (value = "SELECT * FROM $TABLE_NAME WHERE $ID_COL = :arg0")
    override abstract fun getById(id: Int): City

    companion object {
        const val TABLE_NAME = "cities"
        const val ID_COL = "id"
        const val NAME_COL = "name"
    }
}