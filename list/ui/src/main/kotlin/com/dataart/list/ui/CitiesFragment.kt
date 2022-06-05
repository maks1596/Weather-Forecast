package com.dataart.list.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dataart.list.ui.databinding.CitiesBinding
import com.dataart.list.viewmodel.CitiesViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CitiesFragment(
    viewModelLazy: CitiesFragment.() -> Lazy<CitiesViewModel>
) : Fragment(R.layout.cities) {

    private val viewModel by viewModelLazy()

    private val adapter by lazy { CitiesAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.citiesFlow.collect(adapter::submitList)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = CitiesBinding.bind(view)
        binding.root.adapter = adapter
    }
}