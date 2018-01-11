package com.example.mpowloka.androidweartest.model.dao

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.Observer
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Transaction
import android.arch.persistence.room.Update

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

abstract class BaseDao<T: Any> {

    @Insert
    abstract fun insert(vararg args: T): Array<Long>

    @Insert
    abstract fun insert(arg: T) : Long

    @Transaction
    open fun insert(args: List<T>) = args.forEach{insert(it)}

    @Update
    abstract fun update(vararg args: T): Int

    @Update
    abstract fun update(arg: T)

    @Transaction
    open fun update(args: List<T>) = args.forEach{update(it)}

    @Delete
    abstract fun delete(vararg args: T): Int

    @Delete
    abstract fun delete(arg: T)

    @Transaction
    open fun delete(args: List<T>) = args.forEach{delete(it)}

    protected fun <I: Any> LiveData<I>.getDistinct(): LiveData<I> {

        val distinctLiveData = MediatorLiveData<I>()
        distinctLiveData.addSource(
                this,
                object : Observer<I> {

                    private var initialized = false
                    private var lastObj: I? = null

                    override fun onChanged(obj: I?) {
                        if(!initialized) {
                            initialized = true
                            lastObj = obj
                            distinctLiveData.postValue(obj)
                        } else if((obj != null && lastObj != null) || obj != lastObj) {
                            lastObj = obj
                            distinctLiveData.postValue(obj)
                        }
                    }
                })

        return distinctLiveData

    }


}