package com.example.mpowloka.androidweartest.model.persistence.dao

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.Observer
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert

import android.arch.persistence.room.Transaction
import android.arch.persistence.room.Update
import com.example.mpowloka.androidweartest.model.interfaces.Provider

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

abstract class BaseDao<T: Any> : Provider<T> {

    @Insert
    override abstract fun insert(vararg args: T): Array<Long>

    @Insert
    override abstract fun insert(arg: T) : Long

    @Transaction
    override fun insert(args: List<T>) = args.forEach{insert(it)}

    @Update
    override abstract fun update(vararg args: T): Int

    @Update
    override abstract fun update(arg: T)

    @Transaction
    override fun update(args: List<T>) = args.forEach{update(it)}

    @Delete
    override abstract fun delete(vararg args: T): Int

    @Delete
    override abstract fun delete(arg: T)

    @Transaction
    override fun delete(args: List<T>) = args.forEach{delete(it)}

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