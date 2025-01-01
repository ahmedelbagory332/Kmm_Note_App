package com.example.kmmnoteapp.android.presentaion

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmnoteapp.android.utils.generateRandomColor
import com.example.kmmnoteapp.android.utils.getCurrentDateTime
import com.example.kmmnoteapp.data.entity.Note
import com.example.kmmnoteapp.domain.use_case.DeleteNoteUseCase
import com.example.kmmnoteapp.domain.use_case.GetAllNotesUseCase
import com.example.kmmnoteapp.domain.use_case.UpsertNotesUseCase
import kotlinx.coroutines.launch

class NoteViewModel(
    val getAllNotesUseCase: GetAllNotesUseCase,
    val upsertNotesUseCase: UpsertNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(NoteState())
    val state: State<NoteState>
        get() = _state

    init {
        sendIntent(NoteIntent.GetNotes)
    }

    fun sendIntent(intent: NoteIntent) {
        viewModelScope.launch {
            when (intent) {
                is NoteIntent.GetNotes -> getNotes()
                is NoteIntent.InsertNotes -> insertNote()
                is NoteIntent.DeleteNotes -> deleteNote(intent.note)
            }
        }
    }

    private fun getNotes() {
        viewModelScope.launch {
            try {
                _state.value = _state.value.copy(isLoading = true)
                val notesResult = getAllNotesUseCase()
                _state.value = _state.value.copy(
                    notes = notesResult.notes ?: listOf(),
                    error = notesResult.error ?: "",
                    isLoading = false,
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    notes = listOf(),
                    error = e.message ?: "An unexpected error happened",
                    isLoading = false,
                )
            }
        }
    }

    private fun insertNote() {
        viewModelScope.launch {
            try {
                _state.value = _state.value.copy(isLoading = true)
                val notesResult =
                    upsertNotesUseCase(
                        Note(
                            title = _state.value.noteTitle,
                            content = _state.value.noteContent,
                            color = generateRandomColor(),
                            dateCreated = getCurrentDateTime()
                        )
                    )
                _state.value = _state.value.copy(
                    error = notesResult.error ?: "",
                    isLoading = false,
                )
                if (notesResult.error == null)
                    sendIntent(NoteIntent.GetNotes)
                changeNoteTitle("")
                changeNoteContent("")
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    notes = listOf(),
                    error = e.message ?: "An unexpected error happened",
                    isLoading = false,
                )
            }
        }
    }

    private fun deleteNote(note: Note) {
        viewModelScope.launch {
            try {
                _state.value = _state.value.copy(isLoading = true)
                val notesResult = deleteNoteUseCase(note)
                _state.value = _state.value.copy(
                    error = notesResult.error ?: "",
                    isLoading = false,
                )
                if (notesResult.error == null)
                    sendIntent(NoteIntent.GetNotes)
                changeNoteTitle("")
                changeNoteContent("")
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    notes = listOf(),
                    error = e.message ?: "An unexpected error happened",
                    isLoading = false,
                )
            }
        }
    }

    fun changeNoteTitle(title: String) {
        _state.value = _state.value.copy(noteTitle = title)
    }

    fun changeNoteContent(content: String) {
        _state.value = _state.value.copy(noteContent = content)
    }

}