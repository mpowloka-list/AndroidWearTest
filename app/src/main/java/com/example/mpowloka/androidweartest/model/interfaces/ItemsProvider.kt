package com.example.mpowloka.androidweartest.model.interfaces

import com.example.mpowloka.androidweartest.model.persistence.Item

/**
 * Created in Listonic by mpowloka on 12.01.2018.
 */
interface ItemsProvider : Provider<Item> {

    fun getAll(): List<Item>
    fun getById(id: Int): Item

}