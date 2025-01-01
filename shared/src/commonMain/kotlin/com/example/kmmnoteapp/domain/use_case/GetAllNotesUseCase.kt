package com.example.kmmnoteapp.domain.use_case

import com.example.kmmnoteapp.domain.model.NotesResult
import com.example.kmmnoteapp.domain.repo.NoteRepo
import kotlinx.coroutines.flow.first

class GetAllNotesUseCase(private val noteRepo: NoteRepo) {

    suspend operator fun invoke(): NotesResult {
        return try {
            val notes = noteRepo.getAllNotes().first()
            NotesResult(
                notes = notes,
                error = null
            )
        } catch (e: Exception) {
            NotesResult(
                notes = emptyList(),
                error = "${e.message} : An unexpected error happened"
            )
        }
    }
}