package com.infinum.template.room.data.api

import com.infinum.template.room.data.models.ShowEntity
import kotlinx.coroutines.flow.Flow

interface DatabaseApi {
    fun observeShows(): Flow<List<ShowEntity>>
    fun observeShow(showId: String): Flow<ShowEntity>
    suspend fun saveShows(shows: List<ShowEntity>)
}
