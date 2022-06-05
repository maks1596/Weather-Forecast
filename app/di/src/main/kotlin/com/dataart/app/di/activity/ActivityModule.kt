package com.dataart.app.di.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.dataart.list.ui.CitiesFragment
import com.dataart.search.ui.SearchFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Provider

@Module
internal interface ActivityModule {

    @Binds
    @IntoMap
    @ClassKey(SearchFragment::class)
    fun provideSearchFragment(fragment: SearchFragment): Fragment

    @Binds
    @IntoMap
    @ClassKey(CitiesFragment::class)
    fun provideCitiesFragment(fragment: CitiesFragment): Fragment

    companion object {

        @Provides
        fun provideFragmentFactory(
            fragmentProviders: Map<Class<*>, @JvmSuppressWildcards Provider<Fragment>>
        ): FragmentFactory = MainFragmentFactory(fragmentProviders)
    }
}