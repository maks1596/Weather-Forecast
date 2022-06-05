package com.dataart.list.viewmodel

import androidx.lifecycle.ViewModel
import com.dataart.list.CityRepository

/**
 * View model for showing list of selected by user cities
 */
class CitiesViewModel(
    private val cityRepository: CityRepository
) : ViewModel() {

    /**
     * Reactive flow with list of selected by user cities
     */
    val citiesFlow get() = cityRepository.getCities()
}