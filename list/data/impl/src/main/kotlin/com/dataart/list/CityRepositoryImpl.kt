package com.dataart.list

import kotlinx.coroutines.flow.Flow

class CityRepositoryImpl : CityRepository {

    override fun getCities(): Flow<List<City>> {
        TODO("Not yet implemented")
    }

    override suspend fun removeCity(city: City) {
        TODO("Not yet implemented")
    }
}