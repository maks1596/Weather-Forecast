package com.dataart.app.di.db

import android.app.Application
import androidx.room.Room
import com.dataart.app.db.impl.AppDb
import com.dataart.app.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
internal class DatabaseModule {

    @Provides
    @ApplicationScope
    fun provideDatabase(
        application: Application
    ): AppDb = Room.databaseBuilder(
        application,
        AppDb::class.java,
        "weather_forecast.db"
    ).build()

    @Provides
    @Reusable
    fun provideFavouriteCitiesDao(appDb: AppDb) = appDb.favouriteCitiesDao
}