package com.danielnastase.gooder.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danielnastase.gooder.ui.theme.gooderTypography

@Composable
fun SavingAmount(
    savedAmount: String
) {
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "You saved ",
            style = MaterialTheme.gooderTypography.medium_10_12.copy(
//                fontSize = 12.sp,
            ),
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(bottom = 1.dp)
        )
        Text(
            text = savedAmount,
            style = MaterialTheme.gooderTypography.extra_bold_12_11.copy(
//                fontSize = 18.sp
            ),
            color = MaterialTheme.colorScheme.primary
        )
    }
}