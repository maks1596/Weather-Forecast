package com.dataart.list

import com.dataart.model.City
import com.dataart.model.Weather

/**
 * City in list
 */
data class City(
    override val name: String,
    override val weather: Weather,
    override val temperature: Temperature
) : City.WithName,
    City.WithWeather,
    City.WithTemperature<Temperature>