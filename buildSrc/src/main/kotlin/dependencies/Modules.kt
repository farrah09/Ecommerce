package dependencies

import implementation
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Modules {
    const val app = ":app"

    const val core = ":core"
    const val coreUi = ":core-ui"

    const val weatherData = ":feature:weather:weather_data"
    const val weatherDomain = ":feature:weather:weather_domain"
    const val weatherPresentation = ":feature:weather:weather_presentation"

    const val searchData = ":feature:search:search_data"
    const val searchDomain = ":feature:search:search_domain"
    const val searchPresentation = ":feature:search:search_presentation"

}

fun DependencyHandler.core(){
    implementation(project(Modules.core))
}

fun DependencyHandler.coreUi(){
    implementation(project(Modules.coreUi))
}

fun DependencyHandler.weatherData(){
    implementation(project(Modules.weatherData))
}

fun DependencyHandler.weatherDomain(){
    implementation(project(Modules.weatherDomain))
}

fun DependencyHandler.weatherPresentation(){
    implementation(project(Modules.weatherPresentation))
}

fun DependencyHandler.searchData(){
    implementation(project(Modules.searchData))
}

fun DependencyHandler.searchDomain(){
    implementation(project(Modules.searchDomain))
}

fun DependencyHandler.searchPresentation(){
    implementation(project(Modules.searchPresentation))
}
