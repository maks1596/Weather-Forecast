package com.dataart.search.data.impl

import com.dataart.search.model.City
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Service for access to geocoding api of [OpenWeather](https://openweathermap.org/api/geocoding-api)
 */
interface GeoService {

    /**
     * Returns list of city satisfying [cityName]
     *
     * @param limit Number of the cities in the API response (up to 5 results can be returned in the API response)
     */
    @GET("direct")
    fun directGeocoding(
        @Query("q") cityName: String,
        @Query("limit") limit: Int? = null
    ): List<City>
}