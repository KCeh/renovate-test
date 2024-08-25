package com.infinum.template.room.data.di

import android.content.Context
import com.infinum.template.room.data.internal.di.modules.ApiModule
import com.infinum.template.room.data.internal.di.modules.RoomModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        RoomModule::class,
        ApiModule::class,
    ],
)
interface RoomDataComponent : RoomComponentApi {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): RoomDataComponent
    }

    companion object {
        operator fun invoke(context: Context): RoomDataComponent = DaggerRoomDataComponent.factory().create(context)
    }
}
