package com.dataart.app.di.app

import android.app.Application
import com.dataart.app.db.FavouriteCitiesDao
import com.dataart.app.di.db.DatabaseModule
import com.dataart.app.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DatabaseModule::class
    ]
)
interface ApplicationComponent {

    val favouriteCitiesDao: FavouriteCitiesDao

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}