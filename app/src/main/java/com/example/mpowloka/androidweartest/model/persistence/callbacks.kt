package com.example.mpowloka.androidweartest.model.persistence

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.RoomDatabase

/**
 * Created in Listonic by mpowloka on 12.01.2018.
 */

object LogsTableCreator : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {

        db.execSQL("""
            CREATE TABLE IF NOT EXISTS logs (
                'creation_date' TEXT,
                'source' TEXT NOT NULL,
                'message' TEXT NOT NULL
            );
        """.trimIndent())

    }
}

object TriggersInitializer : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {

        db.execSQL("""
            CREATE TRIGGER logs_data_provider
            AFTER INSERT ON logs
            BEGIN
                UPDATE logs SET creation_date = date('now') WHERE creation_date LIKE '' OR creation_date IS NULL;
            END;
        """.trimIndent())

    }


}