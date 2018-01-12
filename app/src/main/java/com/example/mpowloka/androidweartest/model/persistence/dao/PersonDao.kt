package com.example.mpowloka.androidweartest.model.persistence.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import com.example.mpowloka.androidweartest.model.persistence.Item
import com.example.mpowloka.androidweartest.model.persistence.Person
import com.example.mpowloka.androidweartest.model.persistence.PersonItemJoin
import com.example.mpowloka.androidweartest.model.interfaces.PersonsProvider

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

@Dao
abstract class PersonDao: BaseDao<Person>(), PersonsProvider {

    @Query (value = "SELECT * FROM $TABLE_NAME")
    override abstract fun getAll(): List<Person>

    @Query (value = "SELECT * FROM $TABLE_NAME WHERE $ID_COL = :arg0")
    override abstract fun getById(id: Int): Person

    @Query (value = "SELECT $NAME_COL, $SURNAME_COL FROM $TABLE_NAME WHERE $ID_COL = :arg0")
    override abstract fun getFullNameById(id: Int) : PersonsProvider.FullName

    @Query (value = "SELECT $SURNAME_COL FROM $TABLE_NAME")
    protected abstract fun getAllSurnamesProt(): LiveData<String>

    override fun getAllSurnames() = getAllSurnamesProt().getDistinct()

    @Query (value = """
        SELECT i.*
        FROM ${ItemDao.TABLE_NAME} i, ${PersonItemJoinDao.TABLE_NAME} pij
        WHERE i.$ID_COL = pij.${PersonItemJoinDao.ITEM_ID_COL}
        AND pij.${PersonItemJoinDao.PERSON_ID_COL} = :arg0
        """)
    protected abstract fun getPersonItemsProt(personId: Int): List<Item>

    override fun getPersonItems(person: Person) = getPersonItemsProt(person.id!!)

    @Insert
    protected abstract fun addItemToPersonProt(personItemJoin: PersonItemJoin)

    @Transaction
    override fun addItemsToPerson(person: Person, vararg items: Item) = items.forEach{ addItemToPersonProt(PersonItemJoin(person.id!!, it.id!!)) }

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