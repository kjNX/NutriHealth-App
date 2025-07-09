package com.unmsm.nutrihealth_app.data.database

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.toObject
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
import kotlinx.coroutines.tasks.await

const val TAG = "FirestoreRepository"

class FirestoreRepository : DatabaseRepository {
    private val instance = FirebaseFirestore.getInstance()

    val userPath = "user"
    val actorPath = "actor"
    val foodPath = "food"
    val messageSubpath = "message"
    val foodSubpath = "food"
    val runSubpath = "run"

    override suspend fun getFoodHistory(uid: String): List<FoodLog>? {
        try {
            val collection = instance.collection("$userPath/$uid/$foodSubpath")
                .get().await()
            val list = mutableListOf<FoodLog>()
            for(document in collection.documents) {
                val log = document.toObject<FoodLog>()
                if(log != null) list.add(log)
            }
            return list.toList()
        } catch (e: FirebaseFirestoreException) {
            Log.d(TAG, "getActors: Failed to fetch data from Firestore. ${e.message}")
            return null
        } catch (e: Exception) {
            Log.d(TAG, "getActors: An error has ocurred. ${e.message}")
            return null
        }
    }

    override suspend fun addFoodLog(
        uid: String,
        foodLog: FoodLog
    ) {
        try {
            instance.collection("$userPath/$uid/$foodSubpath").add(foodLog).await()
        } catch (e: FirebaseFirestoreException) {
            Log.d(TAG, "getActors: Failed to send data to Firestore. ${e.message}")
        } catch (e: Exception) {
            Log.d(TAG, "getActors: An error has ocurred. ${e.message}")
        }
    }

    override suspend fun getRunHistory(uid: String): List<RunLog>? {
        try {
            val collection = instance.collection("$userPath/$uid/$runSubpath")
                .get().await()
            val list = mutableListOf<RunLog>()
            for(document in collection.documents) {
                val log = document.toObject<RunLog>()
                if(log != null) list.add(log)
            }
            return list.toList()
        } catch (e: FirebaseFirestoreException) {
            Log.d(TAG, "getActors: Failed to fetch data from Firestore. ${e.message}")
            return null
        } catch (e: Exception) {
            Log.d(TAG, "getActors: An error has ocurred. ${e.message}")
            return null
        }
    }

    override suspend fun addRunLog(
        uid: String,
        runLog: RunLog
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(uid: String): User? {
        try {
            val document = instance.document("$userPath/$uid")
                .get().await()
            return document.toObject()
        } catch (e: FirebaseFirestoreException) {
            Log.d(TAG, "getActors: Failed to fetch data from Firestore. ${e.message}")
            return null
        } catch (e: Exception) {
            Log.d(TAG, "getActors: An error has ocurred. ${e.message}")
            return null
        }
    }

    override suspend fun setUser(uid: String, user: User) {
        try {
            instance.document("$userPath/$uid").set(user).await()
        } catch (e: FirebaseFirestoreException) {
            Log.d(TAG, "setUser: Failed to fetch data from Firestore. ${e.message}")
        } catch (e: Exception) {
            Log.d(TAG, "setUser: An error has ocurred. ${e.message}")
        }
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

    override suspend fun getActors(): List<Actor>? {
        try {
            val collection = instance.collection(actorPath).get().await()
            val list = mutableListOf<Actor>()
            for(document in collection.documents) {
                val data = document.toObject<Actor>()
                if(data != null) list.add(data)
            }
            return list.toList()
        } catch (e: FirebaseFirestoreException) {
            Log.d(TAG, "getActors: Failed to fetch data from Firestore. ${e.message}")
            return null
        } catch (e: Exception) {
            Log.d(TAG, "getActors: An error has ocurred. ${e.message}")
            return null
        }
    }

    override suspend fun getFood(category: String): Food? {
        try {
            val document = instance.document("$foodPath/$category").get().await()
            val obj = document.toObject<Food>()
            return obj
        } catch (e: Exception) {
            Log.d(TAG, "getFood: An error has ocurred. ${e.message}")
            return null
        }
    }

    override suspend fun getMessages(
        uid: String,
        actorID: Int
    ): List<Message>? {
        return emptyList()
    }

    override suspend fun addMessage(
        uid: String,
        actorID: Int,
        message: Message
    ) {
        /*
        try {
            instance.document("$userPath/$uid/$messageSubpath/$")
        } catch (e: Exception) {
            Log.d(TAG, "addMessage: ")
        }
         */
    }
}