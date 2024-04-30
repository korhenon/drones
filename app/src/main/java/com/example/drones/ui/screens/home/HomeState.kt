package com.example.drones.ui.screens.home

enum class HomeFormState {
    Location, Service, Summary, Confirmation
}

enum class Service {
    Small, Medium, Big
}

data class HomeState(
    val pickupLocation: String = "проспект Наставников",
    val deliveringLocation: String = "шоссе Революции",
    val service: Service = Service.Small,
    val formState: HomeFormState = HomeFormState.Location
)
