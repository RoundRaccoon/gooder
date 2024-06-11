package com.danielnastase.gooder.model.service.impl

import android.net.Uri
import com.danielnastase.gooder.model.service.StorageService
import com.google.firebase.Firebase
import javax.inject.Inject

class StorageServiceImpl @Inject constructor() : StorageService {
//    private val imagesReference = Firebase
    override suspend fun uploadImage(uri: Uri): String {
        return ""
    }
}