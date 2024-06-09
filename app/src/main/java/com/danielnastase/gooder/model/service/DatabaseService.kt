package com.danielnastase.gooder.model.service

interface DatabaseService {
    suspend fun createUser(email: String, username: String)
    suspend fun isEmailAvailable(email: String): Boolean
}