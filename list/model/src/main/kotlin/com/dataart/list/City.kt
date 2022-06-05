package com.dataart.list

import com.dataart.model.City
import com.dataart.model.Coordinates
import com.dataart.model.Weather

/**
 * City in list
 */
data class City(
    override val name: String,
    override val weather: Weather,
    override val coordinates: Coordinates,
    override val temperature: Temperature,
) : City.WithName,
    City.WithWeather,
    City.WithCoordinates,
    City.WithTemperature<Temperature>