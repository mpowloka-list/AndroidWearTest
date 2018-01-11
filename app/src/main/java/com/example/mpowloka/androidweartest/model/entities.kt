package com.example.mpowloka.androidweartest.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

@Entity(
        tableName = "persons",
        foreignKeys =
        [ForeignKey(entity = City::class, parentColumns = ["id"], childColumns = ["city_id"], onDelete = ForeignKey.SET_NULL)]
)
data class Person(
        @PrimaryKey var id: Int,
        var name: String,
        var surname: String,
        var description: String = "",
        var age: Int,
        @ColumnInfo(name = "city_id") var cityId: Int?
)


@Entity(
        tableName = "items"
)
data class Item(
        @PrimaryKey var id: Int,
        var name: String,
        var price: Double
)

@Entity(
        tableName = "cities"
)
data class City(
        @PrimaryKey var id: Int,
        var name: String
)