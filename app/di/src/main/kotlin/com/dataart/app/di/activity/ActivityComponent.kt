package com.dataart.app.di.activity

import androidx.fragment.app.FragmentFactory
import com.dataart.app.db.FavouriteCitiesDao
import com.dataart.app.di.app.ApplicationComponent
import com.dataart.app.di.scope.ActivityScope
import com.dataart.search.di.SearchFragmentModule
import dagger.Component

@Component(
    dependencies = [
        ApplicationComponent::class
    ],
    modules = [
        ActivityModule::class,
        SearchFragmentModule::class
    ]
)
@ActivityScope
interface ActivityComponent {

    val fragmentFactory: FragmentFactory

    @Component.Factory
    interface Factory {

        fun create(applicationComponent: ApplicationComponent): ActivityComponent
    }
}