package com.danielnastase.gooder.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.danielnastase.gooder.ui.theme.GooderTheme
import com.danielnastase.gooder.ui.theme.Orange
import com.danielnastase.gooder.ui.theme.gooderTypography

@Composable
fun GooderButton(
    onClick: () -> Unit,
    label: String = "",
    width: Dp = 328.dp,
    height: Dp = 48.dp,
    color: Color = Orange
) {
    GooderTheme {
        Button(
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(
                containerColor = color,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .size(width, height)
        ) {
            Text(
                text = label,
                style = MaterialTheme.gooderTypography.semi_bold_16_24
            )
        }
    }
}