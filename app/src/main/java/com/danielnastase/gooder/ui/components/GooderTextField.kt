package com.danielnastase.gooder.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.danielnastase.gooder.R
import com.danielnastase.gooder.ui.theme.GooderTheme
import com.danielnastase.gooder.ui.theme.gooderTypography

@Composable
fun GooderTextField(
    value: String,
    onValueChange: (String) -> Unit,
    title: String,
    placeholder: String,
    isPassword: Boolean = false
) {
    var textVisible by remember { mutableStateOf(!isPassword) }

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
                    textColor = Color.White,
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    focusedIndicatorColor = MaterialTheme.colorScheme.background,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.background,
                ),
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (textVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    if (isPassword) {
                        IconButton(
                            onClick = { textVisible = !textVisible }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.eye),
                                contentDescription = "Show/Hide text"
                            )
                        }
                    }
                }
            )
        }
    }
}