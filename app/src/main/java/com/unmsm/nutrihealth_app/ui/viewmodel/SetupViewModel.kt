package com.unmsm.nutrihealth_app.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.unmsm.nutrihealth_app.ui.state.SetupUiState

class SetupViewModel : ViewModel() {
    var uiState by mutableStateOf(SetupUiState())
        private set
//    val uiState = _uiState.asStateFlow()

    fun setGender(value: Int) { uiState = uiState.copy(genderIndex = value) }

    fun setAge(value: String) {
        if (value.isEmpty()) uiState = uiState.copy(age = "")
        else {
            val parsed = value.toIntOrNull()
            if (parsed != null) uiState = uiState.copy(age = value)
        }
    }

    fun setHeight(value: String) {
        if (value.isEmpty()) uiState = uiState.copy(height = "")
        else {
            val parsed = value.toIntOrNull()
            if (parsed != null) uiState = uiState.copy(height = value)
        }
    }

    fun setWeight(value: String) {
        if (value.isEmpty()) uiState = uiState.copy(weight = "")
        else {
            val parsed = value.toFloatOrNull()
            if (parsed != null) uiState = uiState.copy(weight = value)
        }
    }

    fun setIntensity(value: Float) { uiState = uiState.copy(intensity = value) }

    fun setTargetWeight(value: String) {
        if (value.isEmpty()) uiState = uiState.copy(targetWeight = "")
        else {
            val parsed = value.toFloatOrNull()
            if (parsed != null) uiState = uiState.copy(targetWeight = value)
        }
    }

    fun setMainGoal(value: Int) { uiState = uiState.copy(mainGoal = value) }
}
