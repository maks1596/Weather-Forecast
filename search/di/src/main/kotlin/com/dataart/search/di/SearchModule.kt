package com.dataart.search.di

import androidx.fragment.app.viewModels
import androidx.savedstate.SavedStateRegistryOwner
import com.dataart.search.data.CityRepository
import com.dataart.search.data.impl.CityRepositoryImpl
import com.dataart.search.data.impl.GeoService
import com.dataart.search.ui.SearchFragment
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Provider

@Module
internal interface SearchModule {

    @Binds
    fun bindSavedStateRegistryOwner(fragment: SearchFragment): SavedStateRegistryOwner

    companion object {
        @Provides
        @SearchScope
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
        fun provideRetrofit(): Retrofit {
            val contentType = "application/json".toMediaType()
            val converterFactory = Json.asConverterFactory(contentType)
            return Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/geo/1.0/")
                .addConverterFactory(converterFactory)
                .build()
        }
    }
}