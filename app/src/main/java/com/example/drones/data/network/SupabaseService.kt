package com.example.drones.data.network

import com.example.drones.data.model.Order
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SupabaseService @Inject constructor() {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://axvctqeknlsssbmccfpf.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImF4dmN0cWVrbmxzc3NibWNjZnBmIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTQwNjIwMDQsImV4cCI6MjAyOTYzODAwNH0.lvLJ-an0sWUeAMbQdc4dazjRS788kgoykuCohvFls6Q"
    ) {
        install(Postgrest)
        install(Auth)
    }

    suspend fun loginAsGuest() {
        withContext(Dispatchers.IO) {
            supabase.auth.signInAnonymously()
        }
    }

    suspend fun createOrder(order: Order) {
        withContext(Dispatchers.IO) {
            val user = supabase.auth.currentUserOrNull()
            if (user != null) supabase.from("Orders").insert(order.copy(user_id = user.id))
        }
    }

    suspend fun getOrders(): List<Order> {
        val user = supabase.auth.currentUserOrNull()
        if (user != null) return supabase.from("Orders").select {
            filter {
                eq("user_id", user.id)
            }
        }.decodeList<Order>()
        println("Нэ")
        return listOf()
    }
}