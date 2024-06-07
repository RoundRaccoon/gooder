package com.danielnastase.gooder.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.danielnastase.gooder.R
import com.danielnastase.gooder.ui.components.StoreCard
import com.danielnastase.gooder.ui.theme.GooderTheme

@Composable
fun StoreScreen() {
    GooderTheme {
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            items(5) {
                StoreCard(
                    storeName = "Sushi King",
                    storeDistance = "500 m",
                    storeProducts = "10 products",
                    isFavourite = false,
                    storeBannerPainter = painterResource(id = R.drawable.sushi_king_banner),
                    storeLogoPainter = painterResource(id = R.drawable.sushi_king_logo),
                    visitOnClick = {}
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}