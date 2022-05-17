package com.dataart.search.di

import com.dataart.search.ui.SearchFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [SearchModule::class])
internal interface SearchComponent {

    val viewModelProviderFactory: ViewModelProviderFactory

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance fragment: SearchFragment): SearchComponent
    }
}