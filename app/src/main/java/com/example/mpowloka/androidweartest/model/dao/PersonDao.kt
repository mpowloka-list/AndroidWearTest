package com.example.mpowloka.androidweartest.model.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.mpowloka.androidweartest.model.Person

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

@Dao
abstract class PersonDao: BaseDao<Person>() {

    @Query (value = "SELECT * FROM $TABLE_NAME")
    abstract fun getAll(): List<Person>

    @Query (value = "SELECT * FROM $TABLE_NAME WHERE $ID_COL = :arg0")
    abstract fun getById(id: Int): Person

    @Query (value = "SELECT $NAME_COL, $SURNAME_COL FROM $TABLE_NAME WHERE $ID_COL = :arg0")
    abstract fun getFullNameById(id: Int) : FullName

    @Query ("SELECT $SURNAME_COL FROM $TABLE_NAME")
    protected abstract fun getAllSurnamesProt(): LiveData<String>

    fun getAllSurnames() = getAllSurnamesProt().getDistinct()


    class FullName(
            var name: String = "",
            var surname: String = ""
    )

 companion object {
     const val TABLE_NAME = "persons"
     const val ID_COL = "id"
     const val NAME_COL = "name"
     const val SURNAME_COL = "surname"
     const val DESC_COL = "description"
     const val AGE_COL = "age"
     const val CITY_ID_COL = "city_id"
 }

}