package com.danielnastase.gooder.model

import com.google.firebase.firestore.DocumentId

data class User(
    val email: String = "",
    val username: String = "",
    @DocumentId val docId: String = ""
)