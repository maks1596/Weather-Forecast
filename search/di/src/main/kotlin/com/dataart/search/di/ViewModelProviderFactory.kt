package com.dataart.search.di

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.dataart.search.data.CityRepository
import com.dataart.search.viewModel.SearchViewModel
import javax.inject.Inject

internal class ViewModelProviderFactory @Inject constructor(
    owner: SavedStateRegistryOwner,
    private val cityRepository: CityRepository
) : AbstractSavedStateViewModelFactory(owner, null) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T = SearchViewModel(
        savedStateHandle = handle,
        repository = cityRepository
    ) as T
}