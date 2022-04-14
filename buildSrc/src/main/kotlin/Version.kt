import org.gradle.api.JavaVersion

object Version {
    const val jvmTarget = "1.8"

    object Java {
        val sourceCompatibility get() = JavaVersion.VERSION_1_8
        val targetCompatibility get() = JavaVersion.VERSION_1_8
    }

    object Android {
        const val compileSdk = 32
        const val targetSdk = 32
        const val minSdk = 22
    }

    const val coroutines = "1.3.9"
    const val retrofit = "2.9.0"
    const val lifecycle = "2.4.1"

    object AndroidX {
        const val core = "1.7.0"
        const val appCompat = "1.4.1"
        const val constraintLayout = "2.1.3"
    }

    const val material = "1.5.0"
}