package com.dataart.search.model

import com.dataart.model.City

/**
 * City information to display in search results
 */
data class City(
    override val name: String,
    override val countryName: String
) : City.WithName,
    City.WithCountryName