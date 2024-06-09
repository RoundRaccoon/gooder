package com.danielnastase.gooder.model.service.impl

import android.util.Log
import com.danielnastase.gooder.model.User
import com.danielnastase.gooder.model.service.AuthService
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthServiceImpl @Inject constructor() : AuthService {
    override val currentUser: Flow<User?>
        get() = callbackFlow {

        }

    override val currentUserId: String
        get() = Firebase.auth.currentUser?.uid.orEmpty()

    override fun hasUser(): Boolean {
        return Firebase.auth.currentUser != null
    }

    override suspend fun createUser(email: String, password: String) {
        Firebase.auth.createUserWithEmailAndPassword(email, password).await()
        Log.i(null, currentUserId)
    }

    override suspend fun signIn(email: String, password: String) {
        Firebase.auth.signInWithEmailAndPassword(email, password).await()
    }

    override suspend fun signOut() {
        Firebase.auth.signOut()
    }
}