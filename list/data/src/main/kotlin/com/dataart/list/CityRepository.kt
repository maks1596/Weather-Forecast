package com.dataart.list

import kotlinx.coroutines.flow.Flow

/**
 * Repository for receiving city data for the list of cities
 */
interface CityRepository {

    /**
     * Returns list of saved by user cities
     */
    fun getCities(): Flow<List<City>>

    /**
     * Removes [city] from list of user saved cities
     */
    suspend fun removeCity(city: City)
}