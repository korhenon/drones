package com.example.drones.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.drones.data.utils.NavDestinations
import com.example.drones.ui.screens.home.HomeScreen
import com.example.drones.ui.screens.onboard.OnboardScreen
import com.example.drones.ui.screens.splash.SplashScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = NavDestinations.Splash) {
        composable(NavDestinations.Splash) {
            SplashScreen(navController)
        }
        composable(NavDestinations.Onboarding) {
            OnboardScreen(navController)
        }
        composable(NavDestinations.Home) {
            HomeScreen(navController)
        }
    }
}