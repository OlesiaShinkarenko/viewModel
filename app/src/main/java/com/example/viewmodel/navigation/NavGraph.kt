package com.example.viewmodel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.viewmodel.Authorization
import com.example.viewmodel.Greeting
import com.example.viewmodel.MainScreen
import com.example.viewmodel.Registration

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = Screens.MainScreen.route ){
        composable(route = Screens.Authorization.route){
            Authorization(navController)
        }

        composable(route = Screens.Home.route){
            Greeting()
        }
        
        composable(route = Screens.Registration.route){
            Registration(navController = navController)
        }

        composable(route = Screens.MainScreen.route){
            MainScreen(navHostController = navController)
        }
    }
}