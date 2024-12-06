package com.it.lloydsbankpoc.core.routes

sealed class Routes(val route: String) {
    object News : Routes("News")
    object Settings : Routes("Settings")
    object Details : Routes("Details")
}