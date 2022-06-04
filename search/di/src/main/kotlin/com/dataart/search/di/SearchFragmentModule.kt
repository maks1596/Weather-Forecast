package com.dataart.search.di

import androidx.fragment.app.viewModels
import com.dataart.app.db.FavouriteCitiesDao
import com.dataart.search.ui.SearchFragment
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class SearchFragmentModule {

    @Provides
    fun provideFragment(
        favouriteCitiesDao: FavouriteCitiesDao
    ) = SearchFragment {
        val component = DaggerSearchComponent.factory().create(
            favouriteCitiesDao = favouriteCitiesDao,
            fragment = this
        )
        viewModels { component.viewModelProviderFactory }
    }
}