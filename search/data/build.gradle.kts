plugins {
    kotlin("jvm")
}

java {
    sourceCompatibility = javaSourceCompatibilityVersion
    targetCompatibility = javaTargetCompatibilityVersion
}

dependencies {
    api(project(":search:model"))
}