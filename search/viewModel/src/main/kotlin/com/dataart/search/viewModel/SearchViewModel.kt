package com.dataart.search.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dataart.search.data.CityRepository
import com.dataart.search.model.City
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SearchViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: CityRepository
) : ViewModel() {

    private val _searchQueryFlow = MutableStateFlow(
        savedStateHandle[SEARCH_QUERY_KEY] ?: ""
    )

    /**
     * Flow with current search query
     */
    val searchQueryFlow = _searchQueryFlow.onEach { searchQuery ->
        savedStateHandle[SEARCH_QUERY_KEY] = searchQuery
    }

    /**
     * Is data loading now
     */
    val isLoadingFlow = MutableStateFlow(false)

    /**
     * Flow of cities found via [searchQuery][searchQueryFlow]
     */
    val citiesFlow = searchQueryFlow.debounce(
        timeoutMillis = 500
    ).onEach {
        isLoadingFlow.value = true
    }.mapLatest { query ->
        if (query.isBlank()) emptyList()
        else repository.getCities(query)
    }.onEach {
        isLoadingFlow.value = false
    }

    /**
     * User has changed search query to [searchQuery]
     */
    fun onSearchQueryChanged(searchQuery: String) {
        _searchQueryFlow.value = searchQuery
    }

    /**
     * User clicked on [city]
     */
    fun onCityClicked(city: City) {
        viewModelScope.launch {
            repository.addToFavourites(city)
        }
    }

    private companion object {
        const val SEARCH_QUERY_KEY = "searchQuery"
    }
}