package com.dataart.app.db.impl

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dataart.app.db.FavouriteCitiesDao
import com.dataart.app.db.FavouriteCityEntity

@Database(
    entities = [
        FavouriteCityEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDb : RoomDatabase() {

    abstract val favouriteCitiesDao: FavouriteCitiesDao
}