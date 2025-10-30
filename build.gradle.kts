buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.12.3")
    }
}

plugins {
    id("com.android.application") version "8.12.3" apply false
    id("androidx.navigation.safeargs") version "2.7.4" apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
