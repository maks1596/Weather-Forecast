plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = Version.Android.compileSdk

    defaultConfig {
        applicationId = "com.dataart.weatherforecast"
        minSdk = Version.Android.minSdk
        targetSdk = Version.Android.targetSdk
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
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
    implementation(project(":search:ui"))
    implementation(project(":app:di"))
    implementation(project(":search:di"))

    implementation(Dependency.AndroidX.core)
    implementation(Dependency.AndroidX.appCompat)
    implementation(Dependency.material)

    with(Dependency.AndroidX.Navigation) {
        implementation(fragment)
        implementation(ui)
    }
}