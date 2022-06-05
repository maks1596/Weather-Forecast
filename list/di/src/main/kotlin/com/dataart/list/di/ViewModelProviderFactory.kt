package com.dataart.list.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dataart.list.CityRepository
import com.dataart.list.viewmodel.CitiesViewModel
import javax.inject.Inject

internal class ViewModelProviderFactory @Inject constructor(
    private val cityRepository: CityRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T = CitiesViewModel(
        cityRepository = cityRepository
    ) as T
}