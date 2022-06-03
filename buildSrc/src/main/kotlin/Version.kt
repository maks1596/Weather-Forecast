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

    object Room {
        const val common = "2.4.2"
    }

    const val lifecycle = "2.4.1"
    const val coroutines = "1.3.9"

    const val okHttp = "4.7.2"
    const val okHttpLoggingInterceptor = "4.9.3"
    const val retrofit = "2.9.0"
    const val kotlinSerializationJson = "1.3.2"
    const val retrofitKotlinSerializationConverter = "0.8.0"

    object AndroidX {
        const val core = "1.7.0"
        const val appCompat = "1.4.1"
        const val constraintLayout = "2.1.3"
        const val fragment = "1.4.1"
        const val navigation = "2.4.2"
    }

    const val material = "1.5.0"
    const val dagger = "2.41"
}