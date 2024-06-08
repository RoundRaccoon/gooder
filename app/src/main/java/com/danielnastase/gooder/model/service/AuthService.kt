package com.danielnastase.gooder.model.service

import com.danielnastase.gooder.model.User
import kotlinx.coroutines.flow.Flow

interface AuthService {
    val currentUser: Flow<User?>
    val currentUserId: String
    fun hasUser(): Boolean
    suspend fun createUser(email: String, password: String)
    suspend fun signIn(email: String, password: String)
    suspend fun signOut()
}