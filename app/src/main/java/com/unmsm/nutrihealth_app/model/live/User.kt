package com.unmsm.nutrihealth_app.model

// User define al usuario y sus datos base
data class User(
    val authID: String,
    val name: String,
    val email: String,
    val stage: Int
)
