package com.example.mpowloka.androidweartest.model.interfaces

import android.arch.lifecycle.LiveData
import com.example.mpowloka.androidweartest.model.persistence.Item
import com.example.mpowloka.androidweartest.model.persistence.Person

/**
 * Created in Listonic by mpowloka on 12.01.2018.
 */
interface PersonsProvider : Provider<Person>{


    fun getAll() : List<Person>
    fun getById(id: Int) : Person
    fun getFullNameById(id: Int) : FullName
    fun getAllSurnames() : LiveData<String>
    fun getPersonItems(person: Person) : List<Item>
    fun addItemsToPerson(person: Person, vararg items: Item)

    class FullName(
            var name: String = "",
            var surname: String = ""
    )
}