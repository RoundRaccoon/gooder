package com.danielnastase.gooder.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danielnastase.gooder.R
import com.danielnastase.gooder.ui.theme.GooderTheme
import com.danielnastase.gooder.ui.theme.gooderTypography

@Composable
fun OfferCard(
    offerTitle: String,
    storeName: String,
    storeDistance: String,
    offerPickup: String,
    initialPrice: String,
    discountedPrice: String,
    offerPainter: Painter,
    visitOnClick: () -> Unit,
    isReservedOffer: Boolean = false,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(8.dp)
    ) {
        Image(
            painter = offerPainter,
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(70.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = offerTitle,
                style = MaterialTheme.gooderTypography.cardTitle,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
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
                    iconPainter = painterResource(id = R.drawable.clock),
                    iconSize = 14.dp,
                    iconTint = MaterialTheme.colorScheme.secondary,
                    distance = 2.dp,
                    text = offerPickup,
                    textStyle = MaterialTheme.gooderTypography.cardDetail,
                    textColor = MaterialTheme.colorScheme.secondary
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (isReservedOffer) {
                    SavingAmount(savedAmount = discountedPrice)
                } else {
                    PriceWithDiscount(
                        initialPrice = initialPrice,
                        discountedPrice = discountedPrice)
                }
                Row {
                    if (isReservedOffer) {
                        GooderButtonImage(
                            onClick = {},
                            painter = painterResource(id = R.drawable.qrcode),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                    GooderButton(
                        onClick = visitOnClick,
                        label = "View",
                        labelStyle = MaterialTheme.gooderTypography.semi_bold_12_20,
                        width = 84.dp,
                        height = 32.dp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OfferCardPreview() {
    GooderTheme {
        OfferCard(
            offerTitle = "California Rolls - 6 pieces",
            storeName = "Sushi King",
            storeDistance = "500 m",
            offerPickup = "Between 09:00 PM - 10:00 PM",
            initialPrice = "11.99 lei",
            discountedPrice = "5.99 lei",
            offerPainter = painterResource(id = R.drawable.california_rolls),
            {}
        )
    }
}