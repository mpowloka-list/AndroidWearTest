package com.example.mpowloka.androidweartest.model

import android.arch.persistence.room.*

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

@Entity(
        tableName = "persons",
        foreignKeys =
            [ForeignKey(entity = City::class, parentColumns = ["id"], childColumns = ["city_id"], onDelete = ForeignKey.SET_NULL)],
        indices =
            [Index(value = "city_id", name = "city_id")]
)
data class Person(
        @PrimaryKey var id: Int? = null,
        var name: String = "",
        var surname: String = "",
        var description: String = "",
        var age: Int = -1,
        @ColumnInfo(name = "city_id") var cityId: Int? = null
)


@Entity(
        tableName = "items"
)
data class Item(
        @PrimaryKey var id: Int? = null,
        var name: String = "",
        var price: Double = (-1).toDouble()
)

@Entity(
        tableName = "cities"
)
data class City(
        @PrimaryKey var id: Int? = null,
        var name: String = ""
)