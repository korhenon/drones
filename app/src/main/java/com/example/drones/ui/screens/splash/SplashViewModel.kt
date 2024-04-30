package com.example.drones.ui.screens.splash

import androidx.lifecycle.ViewModel
import com.example.drones.data.local.SharedPreferencesService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val sharedPreferencesService: SharedPreferencesService
) : ViewModel() {
    val isOnboardSkipped get() = sharedPreferencesService.isOnboardSkipped
}