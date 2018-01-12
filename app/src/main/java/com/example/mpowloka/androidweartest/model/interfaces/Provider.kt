package com.example.mpowloka.androidweartest.model.interfaces

/**
 * Created in Listonic by mpowloka on 12.01.2018.
 */
interface Provider<T: Any> {

    fun insert(vararg args: T): Array<Long>
    fun insert(arg: T): Long
    fun insert(args: List<T>)

    fun update(vararg args: T): Int
    fun update(arg: T)
    fun update(args: List<T>)

    fun delete(vararg args: T): Int
    fun delete(arg: T)
    fun delete(args: List<T>)

}