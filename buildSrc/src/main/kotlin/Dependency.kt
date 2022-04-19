object Dependency {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
        const val viewModelSavedState =
            "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.lifecycle}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
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
        const val fragment = "androidx.fragment:fragment-ktx:${Version.AndroidX.fragment}"
    }

    const val material = "com.google.android.material:material:${Version.material}"

    object Dagger {
        const val core = "com.google.dagger:dagger:${Version.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Version.dagger}"
    }
}