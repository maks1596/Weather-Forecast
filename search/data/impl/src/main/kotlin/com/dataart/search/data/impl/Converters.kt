package com.dataart.search.data.impl

import com.dataart.app.db.FavouriteCityEntity
import com.dataart.model.Coordinates
import com.dataart.search.model.City

internal fun City.toEntity() = FavouriteCityEntity(
    longitude = coordinates.longitude,
    latitude = coordinates.latitude,
    country = countryName,
    name = name,
)

internal fun CityDto.toModel() = City(
    name = name,
    countryName = countryName,
    coordinates = Coordinates(
        longitude = longitude,
        latitude = latitude
    )
)