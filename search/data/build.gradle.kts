plugins {
    kotlin("jvm")
}

java {
    sourceCompatibility = Version.Java.sourceCompatibility
    targetCompatibility = Version.Java.targetCompatibility
}

dependencies {
    api(project(":search:model"))
}