package com.infinum.template.room.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.infinum.template.room.data.models.ShowEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShowDao {

    @Query("SELECT * FROM show_table")
    fun getAll(): Flow<List<ShowEntity>>

    @Query("SELECT * FROM show_table WHERE id IS (:showId)")
    fun observeById(showId: String): Flow<ShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<ShowEntity>)
}
