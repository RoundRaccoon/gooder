package com.danielnastase.gooder.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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
    labelStyle: TextStyle,
    width: Dp = 328.dp,
    height: Dp = 48.dp,
    color: Color = Orange
) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .size(width, height)
            .shadow(8.dp, RoundedCornerShape(20.dp)),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = label,
            style = labelStyle
        )
    }
}

@Preview
@Composable
fun PreviewTest() {
    GooderTheme {
        GooderButton(
            onClick = {},
            label = "View",
            labelStyle = MaterialTheme.gooderTypography.semi_bold_12_20,
            width = 84.dp,
            height = 32.dp
        )
    }
}