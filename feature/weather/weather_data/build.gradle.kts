import Google.google
import dependencies.compose
import dependencies.core
import dependencies.hilt
import dependencies.test
import dependencies.weatherDomain
import dependencies.gson

plugins {
    `android-library`
    `kotlin-android`
}

apply<GradlePlugins>()

android {
    namespace = "com.fandroid.weather_data"
}

dependencies {

    core()
    weatherDomain()
    gson()
    google()

    hilt()
    compose()
    test()
    retrofit()
    room()

}