package com.unmsm.nutrihealth_app.logic.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface ItemLog {
    @Composable
    fun GetItemRow(modifier: Modifier = Modifier)
}