package com.dataart.weatherforecast

import android.app.Application
import com.dataart.app.di.app.DaggerApplicationComponent

internal class App : Application() {

    val applicationComponent by lazy {
        DaggerApplicationComponent
            .factory()
            .create(this)
    }
}