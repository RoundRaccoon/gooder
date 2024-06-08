package com.danielnastase.gooder.model

import com.google.firebase.firestore.DocumentId

data class User(
    @DocumentId val id: String = "",
    val email: String = "",
    val username: String = ""
)