package com.example.mpowloka.androidweartest.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.mpowloka.androidweartest.model.Item

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

@Dao
abstract class ItemDao: BaseDao<Item>() {

    @Query(value = "SELECT * FROM $TABLE_NAME")
    abstract fun getAll(): List<Item>

    @Query(value = "SELECT * FROM $TABLE_NAME WHERE $ID_COL = :arg0")
    abstract fun getById(id: Int): Item

    companion object {
        const val TABLE_NAME = "items"
        const val ID_COL = "id"
        const val NAME_COL = "name"
        const val PRICE_COL = "price"
    }
}