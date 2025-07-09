package com.unmsm.nutrihealth_app.model.live

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// RunLog define un evento de actividad física (las caminatas ejecutadas)
data class RunLog(
    val id: Int,
//    val timestamp
    val timeInSeconds: Int,
    val minSpeed: Float,
    val maxSpeed: Float,
    val avgSpeed: Float,
    val distanceMt: Int
) : ItemLog {
    @Composable
    override fun GetItemRow(modifier: Modifier) {

    }
}
