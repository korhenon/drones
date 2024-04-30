package com.example.drones.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomField(
    label: String,
    value: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    TextField(
        value = value,
        onValueChange = { onChange(it) },
        label = { Text(text = label) },
        shape = RoundedCornerShape(7.dp),
        modifier = modifier.border(1.dp, Color(0xFFE9E9E9), RoundedCornerShape(7.dp)),
        colors = TextFieldDefaults.colors(
            focusedLabelColor = MaterialTheme.colorScheme.tertiary,
            unfocusedLabelColor = MaterialTheme.colorScheme.tertiary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedContainerColor = MaterialTheme.colorScheme.background,
            focusedContainerColor = MaterialTheme.colorScheme.background,
            disabledContainerColor = MaterialTheme.colorScheme.background
        ),
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        ),
        maxLines = 1,
        enabled = enabled
    )

}