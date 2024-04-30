package com.example.drones.ui.screens.onboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drones.data.local.SharedPreferencesService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardViewModel @Inject constructor(
    private val sharedPreferencesService: SharedPreferencesService
): ViewModel() {
    fun skip() {
        sharedPreferencesService.isOnboardSkipped = true
    }
}