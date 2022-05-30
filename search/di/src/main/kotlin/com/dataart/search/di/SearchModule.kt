package com.dataart.search.di

import androidx.savedstate.SavedStateRegistryOwner
import com.dataart.search.data.CityRepository
import com.dataart.search.data.impl.ApiKeyInterceptor
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
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create

@Module
internal interface SearchModule {

    @Binds
    fun bindSavedStateRegistryOwner(fragment: SearchFragment): SavedStateRegistryOwner

    companion object {

        @Provides
        @Reusable
        fun provideRepository(geoService: GeoService): CityRepository = CityRepositoryImpl(
            ioDispatcher = Dispatchers.IO,
            geoService = geoService
        )

        @Provides
        fun provideGeoService(retrofit: Retrofit) = retrofit.create<GeoService>()

        @Provides
        @Reusable
        fun provideRetrofit(
            apiKeyInterceptor: ApiKeyInterceptor,
            loggingInterceptor: HttpLoggingInterceptor,
        ): Retrofit {
            val client = OkHttpClient.Builder()
                .addInterceptor(apiKeyInterceptor)
                .addInterceptor(loggingInterceptor)
                .build()
            val contentType = "application/json".toMediaType()
            val converterFactory = Json.asConverterFactory(contentType)
            return Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/geo/1.0/")
                .client(client)
                .addConverterFactory(converterFactory)
                .build()
        }

        @Provides
        @Reusable
        fun provideApiKeyInterceptor() = ApiKeyInterceptor()

        @Provides
        @Reusable
        fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
    }
}