package com.example.mpowloka.androidweartest.model.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.mpowloka.androidweartest.model.persistence.Item
import com.example.mpowloka.androidweartest.model.interfaces.ItemsProvider

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

@Dao
abstract class ItemDao: BaseDao<Item>(), ItemsProvider{

    @Query(value = "SELECT * FROM $TABLE_NAME")
    override abstract fun getAll(): List<Item>

    @Query(value = "SELECT * FROM $TABLE_NAME WHERE $ID_COL = :arg0")
    override abstract fun getById(id: Int): Item



    companion object {
        const val TABLE_NAME = "items"
        const val ID_COL = "id"
        const val NAME_COL = "name"
        const val PRICE_COL = "price"
    }
}