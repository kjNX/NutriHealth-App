package com.unmsm.nutrihealth_app.ui.auth

data class AuthUiState(
    var login: Boolean = true,
    var name: String = "",
    var email: String = "",
    var password: String = ""
)