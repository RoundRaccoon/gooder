package com.danielnastase.gooder.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danielnastase.gooder.ui.theme.GooderTheme
import com.danielnastase.gooder.ui.theme.gooderTypography

@Composable
fun GooderTextField(
    value: String,
    onValueChange: (String) -> Unit,
    title: String,
    placeholder: String
) {
    GooderTheme {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                title,
                color = Color.White,
                style = MaterialTheme.gooderTypography.semi_bold_16_24
            )
            TextField(
                value = value,
                onValueChange = onValueChange,
                placeholder = {
                    Text(
                        placeholder,
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.gooderTypography.semi_bold_16_24
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                ),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun DefaultPreview2() {
    var email by remember { mutableStateOf("") }
    GooderTextField(
        value = email,
        onValueChange = { email = it },
        title = "Email",
        placeholder = "What is your email?")
}