package com.fandroid.core_ui.navigation

sealed class Destination(protected val route: String, vararg params: String) {
    val fullRoute: String = if (params.isEmpty()) route else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{${it}}") }
        builder.toString()
    }

    sealed class NoArgumentsDestination(route: String) : Destination(route) {
        operator fun invoke(): String = route
    }

    data object HomeNavigation : NoArgumentsDestination("Home")

    data object CartScreen : NoArgumentsDestination("cart")

    data object ItemsScreen : NoArgumentsDestination("items")

    data object TransactionsScreen : NoArgumentsDestination("transactions")

    data object CustomersScreen : NoArgumentsDestination("customers")

    data object ReportsScreen : NoArgumentsDestination("reports")

    data object DashboardScreen : NoArgumentsDestination("dashboard")

    data object AccountScreen : NoArgumentsDestination("account")

    data object SuspendedCartsScreen : NoArgumentsDestination("suspendedCarts")

    data object UpsertItemScreen: NoArgumentsDestination("upsertItem")

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