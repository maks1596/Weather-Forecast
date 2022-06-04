package com.dataart.search.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dataart.search.data.CityRepository
import com.dataart.search.model.City
import kotlinx.coroutines.flow.*
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
     * Event for navigating to favourite cities screen
     */
    val navigateToFavouriteCities = MutableSharedFlow<Unit>()

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
            navigateToFavouriteCities.emit(Unit)
        }
    }

    private companion object {
        const val SEARCH_QUERY_KEY = "searchQuery"
    }
}