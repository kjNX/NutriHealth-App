package com.unmsm.nutrihealth_app.data.database

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
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

class FirestoreRepository : DatabaseRepository {
    private val instance = Firebase.firestore

    val userPath = "user"
    val actorPath = "actor"
    val foodPath = "food"

    override suspend fun getFoodHistory(uid: String): List<FoodLog> {
    }

    override suspend fun addFoodLog(
        uid: String,
        foodLog: FoodLog
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun getRunHistory(uid: String): List<RunLog> {
        TODO("Not yet implemented")
    }

    override suspend fun addRunLog(
        uid: String,
        runLog: RunLog
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(uid: String): User {
        TODO("Not yet implemented")
    }

    override suspend fun setUser(uid: String, user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun getUserInitial(): UserInitial {
        TODO("Not yet implemented")
    }

    override suspend fun setUserInitial(userInitial: UserInitial) {
        TODO("Not yet implemented")
    }

    override suspend fun getUserPlan(): UserPlan {
        TODO("Not yet implemented")
    }

    override suspend fun setUserPlan(userPlan: UserPlan) {
        TODO("Not yet implemented")
    }

    override suspend fun getUserTarget(): UserTarget {
        TODO("Not yet implemented")
    }

    override suspend fun setUserTarget(userTarget: UserTarget) {
        TODO("Not yet implemented")
    }

    override suspend fun getUserProgress(): UserProgress {
        TODO("Not yet implemented")
    }

    override suspend fun setUserProgress(userProgress: UserProgress) {
        TODO("Not yet implemented")
    }

    override suspend fun getActors(): List<Actor> {
        instance.collection(actorPath)
    }

    override suspend fun getFood(category: String): Food {
        instance.collection(foodPath).get()
    }

    override suspend fun getMessages(
        uid: String,
        actorID: String
    ): List<Message> {
        TODO("Not yet implemented")
    }

    override suspend fun addMessage(
        uid: String,
        actorID: String,
        message: Message
    ) {
        TODO("Not yet implemented")
    }
}