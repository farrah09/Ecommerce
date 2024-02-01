import Google.google
import dependencies.compose
import dependencies.core
import dependencies.hilt
import dependencies.test

plugins {
    `android-library`
    `kotlin-android`
}

apply<GradlePlugins>()

android {
    namespace = "com.fandroid.weather_domain"
}

dependencies {

    core()

    hilt()
    compose()
    test()

}