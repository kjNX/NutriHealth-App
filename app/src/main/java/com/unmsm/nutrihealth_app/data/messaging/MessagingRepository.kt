package com.unmsm.nutrihealth_app.data.messaging

import com.unmsm.nutrihealth_app.model.live.Actor

interface MessagingRepository {
    suspend fun getResponse(actor: Actor)
}