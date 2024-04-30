package com.example.drones.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.drones.data.utils.NavDestinations
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController, viewModel: SplashViewModel = hiltViewModel()) {
    LaunchedEffect(true) {
        delay(500)
        if (viewModel.isOnboardSkipped) navController.navigate(NavDestinations.Home) {
            popUpTo(NavDestinations.Splash) {
                inclusive = true
            }
        }
        else navController.navigate(NavDestinations.Onboarding) {
            popUpTo(NavDestinations.Splash) {
                inclusive = true
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.primary), contentAlignment = Alignment.Center
    ) {
        Text(
            text = "AERODROP.",
            fontWeight = FontWeight.Black,
            fontSize = 40.sp,
            color = colorScheme.onPrimary
        )
    }
}