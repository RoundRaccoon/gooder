package com.danielnastase.gooder.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val ColorScheme = lightColorScheme(
    primary = Orange,
    secondary = LightGray,
    tertiary = DarkGray,
    background = EerieBlack
)

@Composable
fun GooderTheme(
    content: @Composable () -> Unit
) {
    val gooderTypography = buildGooderTypography()
    CompositionLocalProvider(
        LocalGooderTypography provides gooderTypography
    ) {
        MaterialTheme(
            colorScheme = ColorScheme,
            content = content
        )
    }
}

object GooderTheme {
    val typography: GooderTypography
        @Composable
        get() = LocalGooderTypography.current
}