package com.dataart.search.data.impl

import com.dataart.search.data.CityRepository
import com.dataart.search.model.City

class CityRepositoryImpl : CityRepository {

    override suspend fun getCities(query: String): List<City> {
        TODO("Not yet implemented")
    }
}