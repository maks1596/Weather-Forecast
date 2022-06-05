package com.dataart.list.di

import androidx.fragment.app.viewModels
import com.dataart.app.db.FavouriteCitiesDao
import com.dataart.list.ui.CitiesFragment
import dagger.Module
import dagger.Provides

@Module
class CitiesFragmentModule {

    @Provides
    fun provideFragment(
        favouriteCitiesDao: FavouriteCitiesDao
    ) = CitiesFragment {
        val component = DaggerCitiesComponent.factory().create(
            favouriteCitiesDao = favouriteCitiesDao,
            fragment = this
        )
        viewModels { component.viewModelProviderFactory }
    }
}