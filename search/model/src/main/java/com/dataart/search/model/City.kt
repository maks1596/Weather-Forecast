package com.dataart.search.model

import com.dataart.model.City
import kotlinx.serialization.Serializable

/**
 * City information to display in search results
 */
@Serializable
data class City(
    override val name: String,
    override val countryName: String
) : City.WithName,
    City.WithCountryName