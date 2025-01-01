package com.example.kmmnoteapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.kmmnoteapp.data.entity.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Upsert
    suspend fun upsertNote(note: Note): Long

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note ORDER BY id DESC")
    fun getAllNotes(): Flow<List<Note>>
}