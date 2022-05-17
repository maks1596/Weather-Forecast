package com.dataart.search.di

import androidx.fragment.app.viewModels
import com.dataart.search.ui.SearchFragment
import dagger.Module
import dagger.Provides

@Module
class SearchFragmentModule {

    @Provides
    fun provideFragment() = SearchFragment {
        val component = DaggerSearchComponent.factory().create(this)
        viewModels { component.viewModelProviderFactory }
    }
}