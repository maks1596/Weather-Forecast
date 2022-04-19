package com.dataart.app.di.activity

import androidx.fragment.app.FragmentFactory
import com.dataart.search.di.SearchComponent
import dagger.Component

@Component(
    dependencies = [SearchComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    val fragmentFactory: FragmentFactory

    @Component.Factory
    interface Factory {
        fun create(searchComponent: SearchComponent): ActivityComponent
    }
}