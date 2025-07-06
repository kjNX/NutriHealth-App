package com.unmsm.nutrihealth_app.data.messaging

import com.google.firebase.Firebase
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend
import com.unmsm.nutrihealth_app.model.Agent

class GeminiMessagingRepository : MessagingRepository {
    val model = Firebase.ai(backend = GenerativeBackend.googleAI())
        .generativeModel(modelName = "gemini-2.5-flash")

    override suspend fun getResponse(agent: Agent) {
//        return model.startChat()
    }
}