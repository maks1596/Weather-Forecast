package com.dataart.search.di

import com.dataart.search.ui.SearchFragment
import dagger.Component

@SearchScope
@Component(modules = [SearchModule::class])
interface SearchComponent {

    val searchFragment: SearchFragment
}