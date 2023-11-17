// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {  }
    dependencies{
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
    }
}

plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}