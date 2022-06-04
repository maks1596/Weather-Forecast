package com.dataart.weatherforecast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dataart.app.di.activity.DaggerActivityComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val app = application as App
        val component = DaggerActivityComponent.factory()
            .create(app.applicationComponent)
        supportFragmentManager.fragmentFactory = component.fragmentFactory

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}