plugins {
    kotlin("jvm")
}

java {
    sourceCompatibility = javaSourceCompatibilityVersion
    targetCompatibility = javaTargetCompatibilityVersion
}

dependencies {
    api(project(":list:model"))
    api(Coroutines.core)
}