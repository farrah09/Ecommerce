import dependencies.compose
import dependencies.core
import dependencies.coreUi
import dependencies.hilt
import dependencies.ktx
import dependencies.test
import dependencies.weatherDomain

plugins {
    `android-library`
    `kotlin-android`
}

apply<GradlePlugins>()

android {
    namespace = "com.fandroid.weather_presentation"

}

dependencies {

    coreUi()
    core()
    weatherDomain()

    hilt()
    compose()
    test()
    coil()

}