package com.example.kmmnoteapp.domain.repo


import com.example.kmmnoteapp.data.entity.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepo {
    suspend fun upsertNote(note: Note): Long
    suspend fun deleteNote(note: Note)
    fun getAllNotes(): Flow<List<Note>>
}