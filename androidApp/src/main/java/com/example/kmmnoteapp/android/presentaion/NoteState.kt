package com.example.kmmnoteapp.android.presentaion

import com.example.kmmnoteapp.data.entity.Note

data class NoteState(
    val isLoading: Boolean = false,
    val notes: List<Note> = listOf(),
    val error: String = "",
    val noteTitle: String = "",
    val noteContent: String = ""
)