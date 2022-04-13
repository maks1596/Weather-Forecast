import org.gradle.api.JavaVersion

const val jvmTargetVersion = "1.8"
val javaSourceCompatibilityVersion get() = JavaVersion.VERSION_1_8
val javaTargetCompatibilityVersion get() = JavaVersion.VERSION_1_8

object Android {
    const val compileSdkVersion = 32
    const val targetSdkVersion = 32
    const val minSdkVersion = 22
}

const val coroutinesVersion = "1.3.9"