package com.dataart.search.model

import com.dataart.model.City
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * City information to display in search results
 */
@Serializable
data class City(

    @SerialName("name")
    override val name: String,

    @SerialName("country")
    override val countryName: String
) : City.WithName,
    City.WithCountryName