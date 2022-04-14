object Dependency {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
        const val viewModelSavedState =
            "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.lifecycle}"
    }

    object Coroutines {
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:${Version.AndroidX.core}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.AndroidX.appCompat}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Version.AndroidX.constraintLayout}"
    }

    const val material = "com.google.android.material:material:${Version.material}"
}