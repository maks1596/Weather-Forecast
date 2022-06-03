package com.dataart.app.db

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "favourite_cities",
    primaryKeys = [
        "longitude",
        "latitude"
    ]
)
class FavouriteCityEntity(
    @ColumnInfo(name = "longitude")
    val longitude: Double,
    @ColumnInfo(name = "latitude")
    val latitude: Double,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "country")
    val country: String
)