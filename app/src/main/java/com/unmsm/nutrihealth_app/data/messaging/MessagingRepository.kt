package com.unmsm.nutrihealth_app.data.messaging

import com.unmsm.nutrihealth_app.model.Agent

interface MessagingRepository {
    suspend fun getResponse(agent: Agent)
}