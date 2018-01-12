package com.example.mpowloka.androidweartest.model.persistence

import android.arch.persistence.room.*
import com.example.mpowloka.androidweartest.model.persistence.dao.CityDao
import com.example.mpowloka.androidweartest.model.persistence.dao.ItemDao
import com.example.mpowloka.androidweartest.model.persistence.dao.PersonDao

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

@Entity(
        tableName = PersonDao.TABLE_NAME,
        foreignKeys =
            [ForeignKey(entity = City::class, parentColumns = [CityDao.ID_COL], childColumns = [PersonDao.CITY_ID_COL], onDelete = ForeignKey.SET_NULL)],
        indices =
            [Index(value = [PersonDao.CITY_ID_COL], name = "person_to_city")]
)
data class Person (
        @PrimaryKey var id: Int? = null,
        var name: String = "",
        var surname: String = "",
        var description: String = "",
        var age: Int = 0,
        @ColumnInfo(name = PersonDao.CITY_ID_COL) var cityId: Int? = null
)


@Entity(
        tableName = ItemDao.TABLE_NAME
)
data class Item(
        @PrimaryKey var id: Int? = null,
        var name: String = "",
        var price: Double = (-1).toDouble()
)


@Entity(
        tableName = CityDao.TABLE_NAME
)
data class City(
        @PrimaryKey var id: Int? = null,
        var name: String = ""
)

@Entity(
        tableName = "persons_items_join",
        foreignKeys = [
            ForeignKey(entity = Person::class, childColumns = ["person_id"], parentColumns = ["id"], onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
            ForeignKey(entity = Item::class, childColumns = ["item_id"], parentColumns = ["id"], onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)
        ],
        indices = [
            Index(value = ["person_id"], name = "pij_to_persons"),
            Index(value = ["item_id"], name = "pij_to_items")
        ],
        primaryKeys = ["person_id", "item_id"]
)
data class PersonItemJoin(
        @ColumnInfo(name = "person_id") var parentId: Int,
        @ColumnInfo(name = "item_id") var childId: Int
)


