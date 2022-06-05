package com.dataart.list

import com.dataart.app.db.FavouriteCitiesDao
import com.dataart.model.Coordinates
import com.dataart.model.Units
import com.dataart.model.Weather
import kotlinx.coroutines.flow.map

class CityRepositoryImpl(
    private val favouriteCitiesDao: FavouriteCitiesDao
) : CityRepository {

    override fun getCities() = favouriteCitiesDao.getAll().map { entities ->
        entities.map { entity ->
            City(
                name = entity.name,
                coordinates = Coordinates(
                    longitude = entity.longitude,
                    latitude = entity.latitude,
                ),

                // TODO request real data
                weather = Weather.Sunny,
                temperature = Temperature(
                    units = Units.Imperial,
                    day = 20.0,
                    night = 10.0
                )
            )
        }
    }

    override suspend fun removeCity(
        coordinates: Coordinates
    ) = favouriteCitiesDao.delete(
        longitude = coordinates.longitude,
        latitude = coordinates.latitude
    )
}