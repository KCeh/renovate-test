package com.infinum.template.room.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.infinum.template.room.data.db.dao.ShowDao
import com.infinum.template.room.data.models.ShowEntity

@Database(
    entities = [
        ShowEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class Database : RoomDatabase() {

    abstract fun showDao(): ShowDao
}
