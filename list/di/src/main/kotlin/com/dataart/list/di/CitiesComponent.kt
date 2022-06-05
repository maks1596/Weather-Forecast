package com.dataart.list.di

import com.dataart.app.db.FavouriteCitiesDao
import com.dataart.list.ui.CitiesFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ListModule::class])
internal interface CitiesComponent {

    val viewModelProviderFactory: ViewModelProviderFactory

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance fragment: CitiesFragment,
            @BindsInstance favouriteCitiesDao: FavouriteCitiesDao
        ): CitiesComponent
    }
}