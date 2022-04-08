package com.dataart.model

/**
 * City
 */
sealed interface City{

    interface WithName : City {

        /**
         * Name of the city
         */
        val name: String
    }

    interface WithWeather : City {

        /**
         * Weather at this city
         */
        val weather: Weather
    }

    interface WithCoordinates : City {

        /**
         * Coordinates of the city
         */
        val coordinates: Coordinates
    }


}