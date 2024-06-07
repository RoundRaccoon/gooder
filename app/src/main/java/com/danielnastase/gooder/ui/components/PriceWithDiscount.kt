package com.danielnastase.gooder.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danielnastase.gooder.ui.theme.GooderTheme
import com.danielnastase.gooder.ui.theme.gooderTypography

@Composable
fun PriceWithDiscount(
    initialPrice: String,
    discountedPrice: String
) {
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = initialPrice,
            style = MaterialTheme.gooderTypography.medium_10_12.copy(
                textDecoration = TextDecoration.LineThrough
            ),
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(bottom = 1.dp)
        )
        Text(
            text = discountedPrice,
            style = MaterialTheme.gooderTypography.extra_bold_12_11.copy(
                fontSize = 18.sp
            ),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    GooderTheme {
        PriceWithDiscount(
            initialPrice = "11.99 lei",
            discountedPrice = "5.99 lei"
        )
    }
}