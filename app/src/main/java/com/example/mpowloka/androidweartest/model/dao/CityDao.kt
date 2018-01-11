package com.example.mpowloka.androidweartest.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.mpowloka.androidweartest.model.City

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

@Dao
abstract class CityDao : BaseDao<City>() {

    @Query (value = "SELECT * FROM $TABLE_NAME")
    abstract fun getAll(): List<City>

    @Query (value = "SELECT * FROM ${PersonDao.TABLE_NAME} WHERE ${PersonDao.ID_COL} = :arg0")
    abstract fun getById(id: Int): City

    companion object {
        const val TABLE_NAME = "cities"
        const val ID_COL = "id"
        const val NAME_COL = "name"
    }
}