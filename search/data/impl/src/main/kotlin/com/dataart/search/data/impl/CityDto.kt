package com.dataart.search.data.impl

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data transfer object for receiving cities via geocoding api
 */
@Serializable
data class CityDto(
    @SerialName("name")
    val name: String,
    @SerialName("country")
    val countryName: String,
    @SerialName("lat")
    val latitude: Double,
    @SerialName("lon")
    val longitude: Double,
)