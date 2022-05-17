package com.dataart.weatherforecast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dataart.app.di.activity.DaggerActivityComponent
import com.dataart.search.di.DaggerSearchComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val component = DaggerActivityComponent.create()
        supportFragmentManager.fragmentFactory = component.fragmentFactory

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}