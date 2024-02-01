package dependencies

import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Lottie {
    private val version = "6.1.0"
    val lottie = "com.airbnb.android:lottie-compose:$version"

    fun DependencyHandler.lottie(){
        implementation(Lottie.lottie)
    }
}