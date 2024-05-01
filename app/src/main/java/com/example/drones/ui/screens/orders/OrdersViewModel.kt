package com.example.drones.ui.screens.orders

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drones.data.model.Order
import com.example.drones.data.network.SupabaseService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class OrdersViewModel @Inject constructor(
    private val supabaseService: SupabaseService
) : ViewModel() {
    var orders by mutableStateOf(listOf<Order>())

    fun load() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                orders = supabaseService.getOrders()
            }
        }
    }
}