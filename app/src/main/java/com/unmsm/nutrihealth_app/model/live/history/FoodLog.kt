package com.unmsm.nutrihealth_app.model.live

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.util.Date

// FoodLog define un evento en el que el usuario ha escaneado su comida
data class FoodLog(
    val id: Int,
    val foodId: Int,
    val timestamp: Date
) : ItemLog {
    @Composable
    override fun GetItemRow(modifier: Modifier) {

    }
}
