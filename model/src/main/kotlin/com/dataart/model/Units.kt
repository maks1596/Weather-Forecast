package com.dataart.model

/**
 * Measure units
 */
enum class Units {

    /**
     * Standard measure units:
     * - temperature in Kelvin
     * - wind speed in meter/spec
     */
    Standard,

    /**
     * Metric measure units:
     * - temperature in Celsius
     * - wind speed in meter/spec
     */
    Metric,

    /**
     * Imperial measure Fahrenheit:
     * - temperature in Kelvin
     * - wind speed in miles/hour
     */
    Imperial
}