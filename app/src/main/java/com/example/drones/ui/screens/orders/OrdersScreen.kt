package com.example.drones.ui.screens.orders

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.drones.ui.screens.home.Service

@Composable
fun OrdersScreen(viewModel: OrdersViewModel = hiltViewModel()) {
    LaunchedEffect(true) {
        viewModel.load()
    }
    Column {
        for (order in viewModel.orders) {
            Text(text = "${order.from}-${order.to} Service: ${order.service}")
        }
    }
}