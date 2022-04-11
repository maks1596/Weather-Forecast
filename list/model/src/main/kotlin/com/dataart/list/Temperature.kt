package com.dataart.list

import com.dataart.model.Temperature
import com.dataart.model.Units

/**
 * City temperature to show in list of cities
 */
data class Temperature(
    override val units: Units,
    override val day: Double,
    override val night: Double
) : Temperature.WithUnits,
    Temperature.WithDay,
    Temperature.WithNight