package com.example.kmmnoteapp.android.utils

import android.graphics.Color
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun getCurrentDateTime(): String {
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    return currentDateTime.format(formatter)
}

fun generateRandomColor(): Int {
    return Color.argb(
        255, // Alpha (fully opaque)
        (0..255).random(), // Red
        (0..255).random(), // Green
        (0..255).random()  // Blue
    )
}