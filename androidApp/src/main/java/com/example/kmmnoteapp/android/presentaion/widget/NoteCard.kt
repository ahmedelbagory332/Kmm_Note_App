package com.example.kmmnoteapp.android.presentaion.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kmmnoteapp.data.entity.Note

@Composable
fun NoteCard(note: Note, onDeleteClick: (note: Note) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.inversePrimary)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clip(CircleShape)
                    .size(30.dp)
                    .background(Color(note.color))
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = note.content,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
                )
                Text(
                    text = note.dateCreated,
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium)
                )
            }
            Image(
                imageVector = Icons.Default.Delete,
                colorFilter = ColorFilter.tint(Color.Red),
                contentDescription = "My Image",
                modifier = Modifier.clickable { onDeleteClick(note) }
            )
        }
    }
}