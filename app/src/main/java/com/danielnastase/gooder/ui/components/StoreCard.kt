package com.danielnastase.gooder.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.danielnastase.gooder.R
import com.danielnastase.gooder.ui.theme.gooderTypography

@Composable
fun StoreCard(
    storeName: String,
    storeDistance: String,
    storeProducts: String,
    isFavourite: Boolean,
    storeBannerPainter: Painter,
    storeLogoPainter: Painter,
    visitOnClick: () -> Unit
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .height(124.dp)
        ) {
            Image(
                painter = storeBannerPainter,
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 12.dp, bottom = 10.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Image(
                    painter = storeLogoPainter,
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }
            FavoriteButton(isFavorite = isFavourite)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.tertiary,
                    shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                )
                .padding(12.dp)
        ) {
            Column {
                Text(
                    text = storeName,
                    style = MaterialTheme.gooderTypography.cardTitle,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextWithIcon(
                        iconPainter = painterResource(id = R.drawable.walking),
                        iconSize = 14.dp,
                        iconTint = MaterialTheme.colorScheme.secondary,
                        distance = 2.dp,
                        text = storeDistance,
                        textStyle = MaterialTheme.gooderTypography.cardDetail,
                        textColor = MaterialTheme.colorScheme.secondary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Divider(
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.size(width = 1.dp, height = 12.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    TextWithIcon(
                        iconPainter = painterResource(id = R.drawable.meal),
                        iconSize = 14.dp,
                        iconTint = MaterialTheme.colorScheme.secondary,
                        distance = 2.dp,
                        text = storeProducts,
                        textStyle = MaterialTheme.gooderTypography.cardDetail,
                        textColor = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            GooderButton(
                onClick = visitOnClick,
                label = "Visit",
                labelStyle = MaterialTheme.gooderTypography.semi_bold_12_20,
                width = 84.dp,
                height = 32.dp
            )
        }
    }
}
