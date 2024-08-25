package com.infinum.template.room.bridge.di

import android.content.Context
import com.infinum.template.room.data.di.RoomDataComponent
import dagger.Component

@Component(
    dependencies = [
        RoomDataComponent::class,
    ],
)
interface RoomBridgeComponent : RoomBridgeApi {

    @Component.Factory
    interface Factory {
        fun create(dataComponent: RoomDataComponent): RoomBridgeComponent
    }

    companion object {
        operator fun invoke(context: Context): RoomBridgeComponent = DaggerRoomBridgeComponent
            .factory()
            .create(RoomDataComponent(context))
    }
}
