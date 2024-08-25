package com.infinum.template.room.data.internal.api

import com.infinum.template.room.data.api.DatabaseApi
import com.infinum.template.room.data.db.dao.ShowDao
import com.infinum.template.room.data.models.ShowEntity
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

internal class DatabaseApiImpl @Inject constructor(
    private val showDao: ShowDao,
) : DatabaseApi {
    override fun observeShows(): Flow<List<ShowEntity>> = showDao.getAll()

    override fun observeShow(showId: String): Flow<ShowEntity> = showDao.observeById(showId)

    override suspend fun saveShows(shows: List<ShowEntity>) = showDao.insert(shows)
}
