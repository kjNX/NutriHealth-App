package com.unmsm.nutrihealth_app.util.trick

import androidx.compose.ui.graphics.Color

fun randomValue(min: Int = 0, max: Int = 255) = (min..max).random()

fun randomColor(): Color = Color(randomValue(), randomValue(), randomValue())