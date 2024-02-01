pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "WeatherApp"
include(":app")
include(":core")
include(":core-ui")
include(":feature")
include(":feature:weather")
include(":feature:search")
include(":feature:weather:weather_data")
include(":feature:weather:weather_domain")
include(":feature:weather:weather_presentation")
include(":feature:search:search_data")
include(":feature:search:search_domain")
include(":feature:search:search_presentation")