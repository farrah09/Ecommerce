import dependencies.compose
import dependencies.core
import dependencies.hilt
import dependencies.test
import dependencies.weatherDomain

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

    hilt()
    compose()
    test()
    retrofit()
    room()

}