package com.example.mpowloka.androidweartest.model.persistence.migrations

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration

/**
 * Created in Listonic by mpowloka on 11.01.2018.
 */

class MIGRATION_1_2: Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("""
            CREATE TABLE IF NOT EXISTS persons_items_join (
                'person_id' INTEGER NOT NULL,
                'item_id' INTEGER NOT NULL,
                PRIMARY KEY('person_id', 'item_id'),
                FOREIGN KEY('person_id') REFERENCES persons('id') ON UPDATE CASCADE ON DELETE CASCADE,
                FOREIGN KEY('item_id') REFERENCES items('id') ON UPDATE CASCADE ON DELETE CASCADE
            );
        """.trimIndent())

        database.execSQL("""
            CREATE INDEX pij_to_persons
            ON persons_items_join (person_id);
        """.trimIndent())

        database.execSQL("""
            CREATE INDEX pij_to_items
            ON persons_items_join (item_id);
        """.trimIndent())
    }
}