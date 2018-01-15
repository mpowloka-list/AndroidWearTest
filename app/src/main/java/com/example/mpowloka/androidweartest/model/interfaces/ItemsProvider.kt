package com.example.mpowloka.androidweartest.model.interfaces

import android.arch.lifecycle.LiveData
import com.example.mpowloka.androidweartest.model.persistence.Item

/**
 * Created in Listonic by mpowloka on 12.01.2018.
 */
interface ItemsProvider : Provider<Item> {

    fun getAll(): LiveData<List<Item>>
    fun getById(id: Int): Item

}