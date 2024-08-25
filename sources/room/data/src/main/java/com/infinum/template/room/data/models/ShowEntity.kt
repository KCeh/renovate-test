package com.infinum.template.room.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "show_table")
data class ShowEntity(
    @PrimaryKey @field:ColumnInfo(name = "id") val id: String,
    @field:ColumnInfo(name = "title") val title: String,
    @field:ColumnInfo(name = "imageUrl") val imageUrl: String,
    @field:ColumnInfo(name = "description") val description: String,
)
