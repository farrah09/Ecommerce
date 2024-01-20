import dependencies.compose
import dependencies.hilt
import dependencies.ktx
import dependencies.test

plugins {
    `android-library`
    `kotlin-android`
}

apply<GradlePlugins>()

android {
    namespace = "com.fandroid.core"

}

dependencies {
    hilt()
    compose()
    test()
}