package dependencies

import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

object Gson {
    const val version = "2.10.1"
    const val gsonLibrary = "com.google.code.gson:gson:$version"
}

fun DependencyHandler.gson(){
    implementation(Gson.gsonLibrary)
}