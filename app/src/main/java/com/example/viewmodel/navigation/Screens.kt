package com.example.viewmodel.navigation

sealed class Screens(val route:String) {
    object Authorization : Screens("authorization_screen")
    object Home : Screens("home_screen")

    object Registration : Screens("registration_screen")
    object MainScreen : Screens ("main_screen")
}