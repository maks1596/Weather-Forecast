plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.6.21"
}

java {
    sourceCompatibility = Version.Java.sourceCompatibility
    targetCompatibility = Version.Java.targetCompatibility
}

dependencies {
    api(project(":model"))

    implementation(Dependency.kotlinSerializationJson)
}