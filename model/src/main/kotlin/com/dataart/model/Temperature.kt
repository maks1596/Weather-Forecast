package com.dataart.model

/**
 * Temperature
 */
sealed interface Temperature {

    interface WithUnits : Temperature {

        /**
         * Temperature measure units
         */
        val units: Units
    }

    interface WithDay : Temperature {

        /**
         * Day temperature
         */
        val day: Double
    }

    interface WithNight : Temperature {

        /**
         * Night temperature
         */
        val night: Double
    }
}