package com.unmsm.nutrihealth_app.model

// Food define un tipo de comido, importado de /food/ en Firestore
data class Food(
    val id: Int,
    val name: String = "",
    val calories: Int = 0,
    val protein: Float = 0f,
    val water: Float = 0f,
    val fats: Float = 0f
)
