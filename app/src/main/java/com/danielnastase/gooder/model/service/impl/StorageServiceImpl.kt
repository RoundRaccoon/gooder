package com.danielnastase.gooder.model.service.impl

import android.net.Uri
import com.danielnastase.gooder.model.service.StorageService
import com.google.firebase.Firebase
import com.google.firebase.storage.storage
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class StorageServiceImpl @Inject constructor() : StorageService {
    private val imagesReference = Firebase.storage.reference.child(IMAGES_DIRECTORY)
    companion object {
        private const val IMAGES_DIRECTORY = "images"
    }
    override suspend fun uploadImage(uri: Uri): String {
        val identifier = uri.lastPathSegment
            ?: throw Exception("Uri has null lastPathSegment")
        imagesReference.child(identifier).putFile(uri).await()
        return identifier
    }
}