package com.unmsm.nutrihealth_app.model


// Un Agent define un bot de mensajería.
data class Agent(
    val name: String,
    val description: String,
    val promptBase: String
)
