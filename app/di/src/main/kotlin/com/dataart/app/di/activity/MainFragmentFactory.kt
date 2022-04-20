package com.dataart.app.di.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Provider

internal class MainFragmentFactory(
    private val fragmentProviders: Map<Class<*>, Provider<Fragment>>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentClass = classLoader.loadClass(className)
        val fragmentProvider = fragmentProviders[fragmentClass]
        return if (fragmentProvider != null) fragmentProvider.get()
        else super.instantiate(classLoader, className)
    }
}