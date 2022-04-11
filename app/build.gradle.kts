plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = Android.compileSdkVersion

    defaultConfig {
        applicationId = "com.dataart.weatherforecast"
        minSdk = Android.minSdkVersion
        targetSdk = Android.targetSdkVersion
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
        sourceCompatibility = javaSourceCompatibilityVersion
        targetCompatibility = javaTargetCompatibilityVersion
    }
    kotlinOptions {
        jvmTarget = jvmTargetVersion
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
}