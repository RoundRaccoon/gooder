package com.danielnastase.gooder.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.danielnastase.gooder.R
import com.danielnastase.gooder.ui.components.OfferCard
import com.danielnastase.gooder.ui.theme.GooderTheme

@Composable
fun DiscoverScreen() {
    GooderTheme {
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            items(5) {
                OfferCard(
                    offerTitle = "California Rolls - 6 pieces",
                    storeName = "Sushi King",
                    storeDistance = "500 m",
                    offerPickup = "Between 09:00 PM - 10:00 PM",
                    initialPrice = "11.99 lei",
                    discountedPrice = "5.99 lei",
                    offerPainter = painterResource(id = R.drawable.california_rolls),
                    {},
                    true
                )
                Spacer(Modifier.height(24.dp))
            }
        }
    }
}