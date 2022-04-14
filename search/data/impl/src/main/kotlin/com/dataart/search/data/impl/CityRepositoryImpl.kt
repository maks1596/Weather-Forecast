package com.dataart.search.data.impl

import com.dataart.search.data.CityRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class CityRepositoryImpl(
    private val geoService: GeoService,
    private val ioDispatcher: CoroutineDispatcher
) : CityRepository {

    override suspend fun getCities(query: String) = withContext(ioDispatcher) {
        geoService.directGeocoding(cityName = query)
    }
}