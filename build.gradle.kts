// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.5.20-RC"
    repositories {
        google()
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0-beta04")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
