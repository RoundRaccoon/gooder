package com.danielnastase.gooder.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danielnastase.gooder.R
import com.danielnastase.gooder.ui.theme.gooderTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SushiCard(
    backgroundImage: Painter,
    logoImage: Painter,
    onVisitClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp) // Adjust based on your requirement
            .padding(16.dp),
        shape = RoundedCornerShape(10.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f)) // Dark overlay for better text visibility
        ) {
            Image(
                painter = backgroundImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.BottomStart)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = logoImage,
                        contentDescription = "Logo",
                        modifier = Modifier.size(40.dp) // Adjust size as needed
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            "Sushi King",
                            style = MaterialTheme.gooderTypography.bold_12_11,
                            color = Color.White
                        )
                        Text(
                            "500 m | 10 products",
                            style = MaterialTheme.gooderTypography.regular_08_12,
                            color = Color.White
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = onVisitClicked,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red, // Use your theme color
                        contentColor = Color.White
                    )
                ) {
                    Text("Visit")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSushiCard() {
    SushiCard(
        backgroundImage = painterResource(id = R.drawable.sushi_king_banner),
        logoImage = painterResource(id = R.drawable.sushi_king_logo),
        onVisitClicked = {}
    )
}
