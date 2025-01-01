package com.example.kmmnoteapp.domain.use_case

import com.example.kmmnoteapp.data.entity.Note
import com.example.kmmnoteapp.domain.model.NotesResult
import com.example.kmmnoteapp.domain.repo.NoteRepo

class DeleteNoteUseCase(private val noteRepo: NoteRepo) {

    suspend operator fun invoke(note: Note): NotesResult {
        return try {
            noteRepo.deleteNote(note)
            NotesResult(
                notes = emptyList(),
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