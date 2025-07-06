package com.unmsm.nutrihealth_app.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// FoodLog define un evento en el que el usuario ha escaneado su comida
data class FoodLog(
    val id: Int,
//    val timestamp
    val foodId: Int,
) : ItemLog {
    @Composable
    override fun GetItemRow(modifier: Modifier) {

    }
}
