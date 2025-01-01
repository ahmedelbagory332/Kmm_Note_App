package com.example.kmmnoteapp.android.presentaion

import com.example.kmmnoteapp.data.entity.Note


sealed class NoteIntent {
    data object GetNotes : NoteIntent()
    data object InsertNotes : NoteIntent()
    data class DeleteNotes(val note: Note) : NoteIntent()
}