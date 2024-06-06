package com.danielnastase.gooder.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.danielnastase.gooder.ui.theme.GooderTheme
import com.danielnastase.gooder.ui.theme.gooderTypography

@Composable
fun WelcomeScreen(
    appName: String,
    logoPainter: Painter,
    firstOptionLabel: String,
    firstOptionOnClick: () -> Unit,
    secondOptionLabel: String,
    secondOptionOnClick: () -> Unit,
) {
    GooderTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(16.dp))
            Row (
            ) {
                Text(
                    text = "Welcome to ",
                    style = MaterialTheme.gooderTypography.bold_24_32,
                    color = Color.White,
                )
                Text(
                    text = appName,
                    style = MaterialTheme.gooderTypography.black_24_32,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
            Spacer(Modifier.height(50.dp))
            Image(
                modifier = Modifier
                    .padding(horizontal = 5.dp),
                painter = logoPainter,
                contentDescription = "Gooder Logo")
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 24.dp
                    ),
                contentAlignment = Alignment.BottomStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    GooderButton(
                        onClick = secondOptionOnClick,
                        label = secondOptionLabel,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(Modifier.height(16.dp))
                    GooderButton(
                        onClick = firstOptionOnClick,
                        label = firstOptionLabel
                    )
                }
            }
        }
    }
}