import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.6.21"
}

android {
    compileSdk = Version.Android.compileSdk

    defaultConfig {
        minSdk = Version.Android.minSdk
        targetSdk = Version.Android.targetSdk

        val localProperties = Properties()
        rootProject.file("local.properties").inputStream().use { stream ->
            localProperties.load(stream)
        }
        buildConfigField("String", "OPEN_WEATHER_API_KEY", "\"${localProperties["OPEN_WEATHER_API_KEY"]}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt")
            )
        }
    }
    compileOptions {
        sourceCompatibility = Version.Java.sourceCompatibility
        targetCompatibility = Version.Java.targetCompatibility
    }
    kotlinOptions {
        jvmTarget = Version.jvmTarget
    }
}

dependencies {
    api(project(":search:data"))

    implementation(Dependency.retrofit)
    implementation(Dependency.Coroutines.core)
    implementation(Dependency.kotlinSerializationJson)
}