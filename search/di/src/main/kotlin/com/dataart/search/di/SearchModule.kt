package com.dataart.search.di

import androidx.fragment.app.viewModels
import androidx.savedstate.SavedStateRegistryOwner
import com.dataart.search.data.CityRepository
import com.dataart.search.data.impl.CityRepositoryImpl
import com.dataart.search.data.impl.GeoService
import com.dataart.search.ui.SearchFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Provider

@Module
internal interface SearchModule {

    @Binds
    fun bindSavedStateRegistryOwner(fragment: SearchFragment): SavedStateRegistryOwner

    companion object {
        @Provides
        fun provideFragment(
            provider: Provider<ViewModelProviderFactory>
        ) = SearchFragment {
            viewModels(factoryProducer = provider::get)
        }

        @Provides
        @Reusable
        fun provideRepository(geoService: GeoService): CityRepository = CityRepositoryImpl(
            ioDispatcher = Dispatchers.IO,
            geoService = geoService
        )

        @Provides
        fun provideGeoService(retrofit: Retrofit): GeoService = retrofit.create()

        @Provides
        fun provideRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/geo/1.0/")
            .build()
    }
}