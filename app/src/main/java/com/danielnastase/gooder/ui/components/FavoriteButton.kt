package com.danielnastase.gooder.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.danielnastase.gooder.R

@Composable
fun FavoriteButton(
    isFavorite: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp, end = 12.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Box(
            modifier = Modifier
                .background(Color(0x99000000), CircleShape)
                .padding(5.dp)
        ) {
            Image(
                painter = if (isFavorite) painterResource(id = R.drawable.heart_filled) else painterResource(id = R.drawable.heart_outline),
                contentDescription = "",
                modifier = Modifier
            )
        }
    }
}