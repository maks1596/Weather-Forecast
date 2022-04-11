plugins {
    kotlin("jvm")
}

java {
    sourceCompatibility = javaSourceCompatibilityVersion
    targetCompatibility = javaTargetCompatibilityVersion
}

dependencies {
    api(project(":list:model"))
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
}