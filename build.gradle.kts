plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin) apply false

}

buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.5.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
    // Define global properties
    extra["compose_version"] = "1.3.0" // 适合你的Compose版本
    extra["kotlin_version"] = "1.8.10" // 适合你的Compose版本的Kotlin版本
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
