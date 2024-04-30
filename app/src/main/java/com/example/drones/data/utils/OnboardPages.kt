package com.example.drones.data.utils

import com.example.drones.R

data class OnboardPage(
    val title: String,
    val text: String,
    val image: Int
)

val OnboardPages = listOf(
    OnboardPage(
        "Elevate your Deliveries",
        "Say goodbye to long wait times and hello to same-day deliveries.",
        R.drawable.onboard1
    ),
    OnboardPage(
        "Precision Route Planning",
        "Our intelligent route planning software guarantees the optimal path for each delivery.",
        R.drawable.onboard2
    ),
    OnboardPage(
        "Environmental Responsibility",
        "Our intelligent route planning software guarantees the optimal path for each delivery.",
        R.drawable.onboard3
    ),
)