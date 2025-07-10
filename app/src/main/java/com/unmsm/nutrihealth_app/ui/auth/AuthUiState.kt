package com.unmsm.nutrihealth_app.ui.auth

data class AuthUiState(
    var login: Boolean = true,
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var errorMessage: String = "",
    var status: Status = Status.NONE
) {
    enum class Status {
        NONE, LOADING, FAILED, SUCCESS
    }
}