package com.danielnastase.gooder.model.service

import android.net.Uri

interface StorageService {
    suspend fun uploadImage(uri: Uri): String
}