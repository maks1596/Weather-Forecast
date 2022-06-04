package com.dataart.search.data.impl

import com.dataart.app.db.FavouriteCitiesDao
import com.dataart.search.data.CityRepository
import com.dataart.search.model.City
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class CityRepositoryImpl(
    private val geoService: GeoService,
    private val favouriteCitiesDao: FavouriteCitiesDao,
    private val ioDispatcher: CoroutineDispatcher
) : CityRepository {

    override suspend fun getCities(query: String) = withContext(ioDispatcher) {
        geoService.directGeocoding(
            cityName = query, limit = CITIES_LIMIT
        ).map { it.toModel() }
    }

    override suspend fun addToFavourites(city: City) = withContext(ioDispatcher) {
        val entity = city.toEntity()
        favouriteCitiesDao.tryInsert(entity)
    }

    private companion object {
        /**
         * Number of the locations in the API response
         * (up to 5 results can be returned in the API response)
         *
         * [https://openweathermap.org/api/geocoding-api]
         */
        private const val CITIES_LIMIT = 5
    }
}