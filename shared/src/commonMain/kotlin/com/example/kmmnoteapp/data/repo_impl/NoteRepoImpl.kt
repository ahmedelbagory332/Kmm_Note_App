package com.example.kmmnoteapp.data.repo_impl


import com.example.kmmnoteapp.data.entity.Note
import com.example.kmmnoteapp.data.local.NoteDataBase
import com.example.kmmnoteapp.domain.repo.NoteRepo
import kotlinx.coroutines.flow.Flow

class NoteRepoImpl(private val noteDataBase: NoteDataBase) : NoteRepo {

    override suspend fun upsertNote(note: Note): Long {
        return noteDataBase.noteDao().upsertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDataBase.noteDao().deleteNote(note)
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDataBase.noteDao().getAllNotes()
    }

}