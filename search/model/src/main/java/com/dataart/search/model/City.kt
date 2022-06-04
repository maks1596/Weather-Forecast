package com.dataart.search.model

import com.dataart.model.City
import com.dataart.model.Coordinates

/**
 * City information to display in search results
 */
data class City(
    override val name: String,
    override val countryName: String,
    override val coordinates: Coordinates
) : City.WithName,
    City.WithCountryName,
    City.WithCoordinates