package com.danielnastase.gooder.ui.components

import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.danielnastase.gooder.R
import com.danielnastase.gooder.ui.theme.gooderTypography

@Composable
fun GooderTopAppBar(
    title: String
) {
    CenterAlignedTopAppBar(
        title = {
            Text (
                text = title,
                style = MaterialTheme.gooderTypography.semi_bold_16_24,
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            navigationIconContentColor = Color.White
        ),
        navigationIcon = {
            val context = LocalContext.current
            Icon(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        (context as ComponentActivity).finish()
                    }
            )
        },
    )
}