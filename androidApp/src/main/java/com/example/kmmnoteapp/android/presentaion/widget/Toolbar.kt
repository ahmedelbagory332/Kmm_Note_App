package com.example.kmmnoteapp.android.presentaion.widget

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Toolbar(title: String, onClick: () -> Unit) {
    CenterAlignedTopAppBar(
        colors = centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.inversePrimary
        ),
        modifier = Modifier
            .shadow(8.dp),
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                onClick()
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add",
                    tint = Color.Unspecified
                )
            }
        },
    )
}