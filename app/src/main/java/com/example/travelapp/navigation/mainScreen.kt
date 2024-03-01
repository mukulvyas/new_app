package com.example.travelapp.navigation

enum class mainScreen {
    cityScreen,
    ContentScreen;
    companion object {
        fun fromRoute(route : String?): mainScreen
        = when (route?.substringBefore("/")){
            cityScreen.name -> cityScreen
            ContentScreen.name -> ContentScreen
            null -> cityScreen
            else -> throw IllegalArgumentException("Route $route is not recongnize")
        }
    }
}