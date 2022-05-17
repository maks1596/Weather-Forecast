package com.dataart.app.di.activity

import androidx.fragment.app.FragmentFactory
import com.dataart.search.di.SearchFragmentModule
import dagger.Component

@Component(
    modules = [
        ActivityModule::class,
        SearchFragmentModule::class
    ]
)
interface ActivityComponent {

    val fragmentFactory: FragmentFactory
}