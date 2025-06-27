package com.unmsm.nutrihealth_app.logic.model

data class Food(
    val name: String = "",
    val calories: Int = 0,
    val protein: Float = 0f,
    val carbs: Float = 0f,
    val fats: Float = 0f
)
