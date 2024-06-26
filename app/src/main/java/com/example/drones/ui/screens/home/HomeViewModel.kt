package com.example.drones.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drones.data.model.Order
import com.example.drones.data.network.SupabaseService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val supabaseService: SupabaseService
) : ViewModel() {
    var state by mutableStateOf(HomeState())

    fun createOrder() {
        viewModelScope.launch {
            supabaseService.createOrder(Order(
                from = state.pickupLocation,
                to = state.deliveringLocation,
                service = state.service.name
            ))
        }
    }
}