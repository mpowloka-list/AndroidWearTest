package com.example.mpowloka.androidweartest.model.interfaces

import com.example.mpowloka.androidweartest.model.persistence.City

/**
 * Created in Listonic by mpowloka on 12.01.2018.
 */
interface CitiesProvider : Provider<City> {

    fun getAll(): List<City>
    fun getById(id: Int): City

}