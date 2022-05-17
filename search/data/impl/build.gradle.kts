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