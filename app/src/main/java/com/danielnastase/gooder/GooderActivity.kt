package com.danielnastase.gooder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.danielnastase.gooder.ui.presentation.GooderApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GooderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = getColor(R.color.black)

        setContent { GooderApp() }
    }
}