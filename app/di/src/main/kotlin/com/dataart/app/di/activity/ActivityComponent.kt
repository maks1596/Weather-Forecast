package com.dataart.app.di.activity

import androidx.fragment.app.FragmentFactory
import com.dataart.search.di.SearchComponent
import dagger.Component

@ActivityScope
@Component(
    dependencies = [SearchComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    val fragmentFactory: FragmentFactory
}