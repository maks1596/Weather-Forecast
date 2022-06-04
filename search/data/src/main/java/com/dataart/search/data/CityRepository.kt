package com.dataart.search.data

import com.dataart.search.model.City

/**
 * Repository for cities on search screen
 */
interface CityRepository {

    /**
     * Returns list of cities according to provided [search query][query]
     */
    suspend fun getCities(query: String): List<City>

    /**
     * Adds [city] to the list of favourite cities
     */
    suspend fun addToFavourites(city: City)
}