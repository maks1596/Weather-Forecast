package com.dataart.app.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Data access object for manipulating favourite cities in database
 */
@Dao
interface FavouriteCitiesDao {

    /**
     * Tries to insert new favourite city in database.
     * If [city] already exists in favourites then insertion will be ignored.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun tryInsert(city: FavouriteCityEntity)

    /**
     * Returns reactive flow of all favourite cities
     */
    @Query("SELECT * FROM favourite_cities")
    fun getAll(): Flow<FavouriteCityEntity>

    /**
     * Does the city already saved as favourite
     */
    @Query(
        """
        SELECT COUNT(longitude)
        FROM FAVOURITE_CITIES 
        WHERE :favouriteCityLongitude = longitude
            AND :favouriteCityLatitude = latitude
        LIMIT 1
        """
    )
    suspend fun isCityFavourite(
        favouriteCityLongitude: Double,
        favouriteCityLatitude: Double
    ): Boolean
}