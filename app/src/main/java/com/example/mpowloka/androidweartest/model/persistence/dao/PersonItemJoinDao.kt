package com.example.mpowloka.androidweartest.model.persistence.dao

import android.arch.persistence.room.Dao
import com.example.mpowloka.androidweartest.model.persistence.PersonItemJoin

/**
 * Created in Listonic by mpowloka on 12.01.2018.
 */

@Dao
abstract class PersonItemJoinDao : BaseDao<PersonItemJoin>() {


    companion object {
        const val TABLE_NAME = "persons_items_join"
        const val PERSON_ID_COL = "person_id"
        const val ITEM_ID_COL = "item_id"
    }

}