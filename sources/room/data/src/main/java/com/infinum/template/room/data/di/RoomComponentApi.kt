package com.infinum.template.room.data.di

import com.infinum.template.room.data.api.DatabaseApi

/**
 * Lists all the implementations provided by the room module.
 * The implementations provided can be used in other modules that depend on the room module.
 * The methods in this interface can be used to obtain the implementations provided.
 */
interface RoomComponentApi {
    fun databaseApi(): DatabaseApi
}
