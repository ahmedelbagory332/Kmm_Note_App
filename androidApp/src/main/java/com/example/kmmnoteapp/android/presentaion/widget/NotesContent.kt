package com.example.kmmnoteapp.android.presentaion.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.kmmnoteapp.android.presentaion.NoteState
import com.example.kmmnoteapp.data.entity.Note


@Composable
fun NotesContent(
    paddingValues: PaddingValues,
    state: NoteState,
    onDeleteClick: (note: Note) -> Unit
) {
    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LoadingIndicator()
        }
    } else if (state.error.isNotEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            ErrorHolder(text = state.error)
        }
    } else {
        if (state.notes.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "There is no notes",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
        } else
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(items = state.notes) { note ->
                NoteCard(note){
                    onDeleteClick(it)
                }
            }
        }
    }
}