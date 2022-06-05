package com.dataart.list.di

import com.dataart.app.db.FavouriteCitiesDao
import com.dataart.list.CityRepository
import com.dataart.list.CityRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
internal class ListModule {

    @Provides
    fun provideRepository(
        favouriteCitiesDao: FavouriteCitiesDao
    ): CityRepository = CityRepositoryImpl(
        favouriteCitiesDao
    )
}