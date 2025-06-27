package com.unmsm.nutrihealth_app.ui.state

data class SetupUiState(
    var genderIndex: Int = 0,
    var intensity: Float = 0f,
    var age: String = "",
    var height: String = "",
    var weight: String = "",
    var targetWeight: String = "",
    var mainGoal: Int = 0,
    var tmb: Int = 0,
    var recommendedKcal: Int = 0,
    var protein: Int = 0,
    var carbs: Int = 0,
    var fats: Int = 0,
    var timeToReach: Int = 0
)
