package com.dataart.search.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.dataart.search.view.databinding.SearchBinding
import com.dataart.search.viewModel.SearchViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchFragment(
    viewModelLazy: Lazy<SearchViewModel>
) : Fragment(R.layout.search),
    SearchView.OnQueryTextListener {

    private val viewModel by viewModelLazy

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = SearchBinding.bind(view)

        binding.toolbar.cityNameSearchView.configure()
        binding.citiesRecyclerView.configure()
    }

    // region SearchView.OnQueryTextListener

    override fun onQueryTextChange(newText: String?): Boolean {
        newText ?: return false
        viewModel.onSearchQueryChanged(newText)
        return true
    }

    override fun onQueryTextSubmit(query: String?) = false

    // endregion SearchView.OnQueryTextListener

    private fun SearchView.configure() {
        setOnQueryTextListener(this@SearchFragment)

        fun updateQuery(newQuery: String) {
            val currentQuery = query
            if (currentQuery == newQuery) return
            setQuery(newQuery, /*submit =*/false)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchQueryFlow.collect(::updateQuery)
            }
        }
    }

    private fun RecyclerView.configure() {
        val adapter = CityAdapter()
        this.adapter = adapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.citiesFlow.collect(adapter::submitList)
            }
        }
    }
}