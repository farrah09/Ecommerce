package com.fandroid.core_ui.navigation

import com.fandroid.core_ui.navigation.Route.ERROR
import com.fandroid.core_ui.navigation.Route.SEARCH
import com.fandroid.core_ui.navigation.Route.WELCOME
import com.fandroid.core_ui.navigation.Route.Weather

sealed class Destination(protected val route: String, vararg params: String) {
    val fullRoute: String = if (params.isEmpty()) route else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{${it}}") }
        builder.toString()
    }

    sealed class NoArgumentsDestination(route: String) : Destination(route) {
        operator fun invoke(): String = route
    }

    data object WelcomeScreen : NoArgumentsDestination(WELCOME)

    data object WeatherScreen : NoArgumentsDestination(Weather)

    data object SearchScreen : NoArgumentsDestination(SEARCH)

    data object ErrorScreen : NoArgumentsDestination(ERROR)

}

internal fun String.appendParams(vararg params: Pair<String, Any?>): String {
    val builder = StringBuilder(this)

    params.forEach {
        it.second?.toString()?.let { arg ->
            builder.append("/$arg")
        }
    }

    return builder.toString()
}