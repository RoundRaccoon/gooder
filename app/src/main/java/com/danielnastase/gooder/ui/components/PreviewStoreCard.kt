package com.danielnastase.gooder.ui.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.danielnastase.gooder.R
import com.danielnastase.gooder.ui.theme.gooderTypography

@Composable
fun PreviewStoreCard(
    name: String,
    logo: Uri?,
    banner: Uri?
) {
    val isFavorite = remember { mutableStateOf(true) }

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
            if (banner == null)
                Image(
                    painter = painterResource(R.drawable.default_banner),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                )
            else
                AsyncImage(
                    model = banner,
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
                if (logo == null)
                    Image(
                        painter = painterResource(R.drawable.default_logo),
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                else
                    AsyncImage(
                        model = logo,
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
            }
            FavoriteButton(isFavorite.value) { isFavorite.value = !isFavorite.value }
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
                    text = name,
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
                        text = "500 m",
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
                        text = "10 products",
                        textStyle = MaterialTheme.gooderTypography.cardDetail,
                        textColor = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            GooderButton(
                onClick = {},
                label = "Visit",
                labelStyle = MaterialTheme.gooderTypography.semi_bold_12_20,
                width = 84.dp,
                height = 32.dp
            )
        }
    }
}