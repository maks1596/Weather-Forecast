plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
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
    implementation(project(":search:viewModel"))
    implementation(project(":search:ui"))
    implementation(project(":search:data:impl"))

    with(Dependency.Dagger) {
        implementation(core)
        kapt(compiler)
    }

    implementation(Dependency.retrofit)
    implementation(Dependency.Lifecycle.viewModelSavedState)
    implementation(Dependency.AndroidX.fragment)
}