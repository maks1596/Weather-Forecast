plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Version.Android.compileSdk

    defaultConfig {
        minSdk = Version.Android.minSdk
        targetSdk = Version.Android.targetSdk
    }

    buildFeatures.viewBinding = true

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

    with(Dependency.AndroidX) {
        implementation(core)
        implementation(appCompat)
        implementation(constraintLayout)
    }
    implementation(Dependency.Lifecycle.runtime)
    implementation(Dependency.material)
}