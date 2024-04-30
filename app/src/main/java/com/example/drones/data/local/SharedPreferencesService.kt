package com.example.drones.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferencesService @Inject constructor(
    @ApplicationContext
    private val context: Context
) {
    private val sp get() = context.getSharedPreferences("DRONES_SP", Context.MODE_PRIVATE)

    var isOnboardSkipped
        get() = sp.getBoolean("isOnboardSkipped", false)
        set(value) {
            val editor = sp.edit()
            editor.putBoolean("isOnboardSkipped", value)
            editor.apply()
        }
}