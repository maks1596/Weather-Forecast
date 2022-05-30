package com.dataart.search.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.dataart.search.data.CityRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onEach

class SearchViewModel(
    savedStateHandle: SavedStateHandle,
    repository: CityRepository
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

    private companion object {
        const val SEARCH_QUERY_KEY = "searchQuery"
    }
}