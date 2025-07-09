package com.unmsm.nutrihealth_app.data.database

import com.unmsm.nutrihealth_app.model.live.Actor
import com.unmsm.nutrihealth_app.model.live.Food
import com.unmsm.nutrihealth_app.model.live.Message
import com.unmsm.nutrihealth_app.model.live.User
import com.unmsm.nutrihealth_app.model.live.history.FoodLog
import com.unmsm.nutrihealth_app.model.live.history.RunLog
import com.unmsm.nutrihealth_app.model.live.stage.UserInitial
import com.unmsm.nutrihealth_app.model.live.stage.UserPlan
import com.unmsm.nutrihealth_app.model.live.stage.UserProgress
import com.unmsm.nutrihealth_app.model.live.stage.UserTarget

interface DatabaseRepository {
    // HISTORY
    suspend fun getFoodHistory(uid: String) : List<FoodLog>?
    suspend fun addFoodLog(uid: String, foodLog: FoodLog)
    suspend fun getRunHistory(uid: String) : List<RunLog>?
    suspend fun addRunLog(uid: String, runLog: RunLog)

    // USERDATA
    suspend fun getUser(uid: String) : User?
    suspend fun setUser(uid: String, user: User)
    suspend fun getUserInitial() : UserInitial?
    suspend fun setUserInitial(userInitial: UserInitial)
    suspend fun getUserPlan() : UserPlan?
    suspend fun setUserPlan(userPlan: UserPlan)
    suspend fun getUserTarget() : UserTarget?
    suspend fun setUserTarget(userTarget: UserTarget)
    suspend fun getUserProgress() : UserProgress?
    suspend fun setUserProgress(userProgress: UserProgress)

    // READ-ONLY
    suspend fun getActors() : List<Actor>?
    suspend fun getFood(category: String) : Food?

    // MESSAGING
    suspend fun getMessages(uid: String, actorID: Int) : List<Message>?
    suspend fun addMessage(uid: String, actorID: Int, message: Message)
}