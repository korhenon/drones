package com.example.drones.data.model

import kotlinx.datetime.DateTimeUnit
import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val id: Int = 0,
    val from: String,
    val to: String,
    val service: String,
    val user_id: String = ""
)
