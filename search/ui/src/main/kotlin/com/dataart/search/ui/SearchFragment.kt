package com.dataart.search.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dataart.search.ui.databinding.SearchBinding
import com.dataart.search.viewModel.SearchViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchFragment(
    viewModelLazy: SearchFragment.() -> Lazy<SearchViewModel>
) : Fragment(R.layout.search) {

    private val viewModel by viewModelLazy()

    private val adapter by lazy {
        CityAdapter(viewModel::onCityClicked)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.citiesFlow.collect(adapter::submitList)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = SearchBinding.bind(view)

        binding.toolbar.cityNameSearchView.configure()
        binding.citiesRecyclerView.adapter = adapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.isLoadingFlow.collect {
                    binding.requestProgressIndicator.isInvisible = !it
                }
            }
        }
    }

    private fun SearchView.configure() {
        val listener = object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                newText ?: return false
                viewModel.onSearchQueryChanged(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String?) = false
        }
        setOnQueryTextListener(listener)

        fun updateQuery(newQuery: String) {
            val currentQuery = query
            if (currentQuery == newQuery) return
            setQuery(newQuery, /*submit =*/false)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.searchQueryFlow.collect(::updateQuery)
            }
        }
    }

}