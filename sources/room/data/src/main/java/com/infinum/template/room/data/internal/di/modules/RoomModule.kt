package com.infinum.template.room.data.internal.di.modules

import android.content.Context
import androidx.room.Room
import com.infinum.template.room.data.db.Database
import dagger.Module
import dagger.Provides

@Module
internal class RoomModule {

    @Provides
    fun database(context: Context) =
        Room.databaseBuilder(
            context,
            Database::class.java,
            "shows.db",
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun showDao(database: Database) = database.showDao()
}
