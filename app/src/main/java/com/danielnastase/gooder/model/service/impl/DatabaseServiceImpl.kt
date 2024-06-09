package com.danielnastase.gooder.model.service.impl

import android.util.Log
import com.danielnastase.gooder.model.User
import com.danielnastase.gooder.model.service.DatabaseService
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class DatabaseServiceImpl @Inject constructor() : DatabaseService {
    private val usersCollectionRef = Firebase.firestore.collection(USERS_COLLECTION)
    companion object {
        private const val USERS_COLLECTION = "users"
        private const val USERS_COLLECTION_EMAIL_FIELD = "email"
    }

    override suspend fun createUser(email: String, username: String) {
        val user = User(email, username)
        usersCollectionRef.add(user).await()
    }

    override suspend fun isEmailAvailable(email: String): Boolean {
        val querySnapshot = usersCollectionRef
            .whereEqualTo(USERS_COLLECTION_EMAIL_FIELD, email)
            .get()
            .await()
        Log.i("snapshot", "" + querySnapshot + " " + querySnapshot.isEmpty + " " + querySnapshot.documents.isEmpty())
        return querySnapshot.isEmpty
    }
}