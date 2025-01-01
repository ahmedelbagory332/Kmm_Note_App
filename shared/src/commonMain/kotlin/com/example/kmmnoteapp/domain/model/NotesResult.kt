package com.example.kmmnoteapp.domain.model

import com.example.kmmnoteapp.data.entity.Note

data class NotesResult(
    val notes: List<Note>? = null,
    val error: String? = null
)
