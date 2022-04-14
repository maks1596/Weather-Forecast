package com.dataart.search.data.impl

import com.dataart.search.data.CityRepository

class CityRepositoryImpl(
    private val geoService: GeoService
) : CityRepository {

    override suspend fun getCities(query: String) =
        geoService.directGeocoding(cityName = query)
}