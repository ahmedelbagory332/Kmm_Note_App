package com.example.kmmnoteapp.di

import com.example.kmmnoteapp.domain.use_case.DeleteNoteUseCase
import com.example.kmmnoteapp.domain.use_case.GetAllNotesUseCase
import com.example.kmmnoteapp.domain.use_case.UpsertNotesUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

// This class is used for injecting in the iOS

class DIHelper : KoinComponent {
    val getAllNotesUseCase: GetAllNotesUseCase by inject()
    val upsertNotesUseCase: UpsertNotesUseCase by inject()
    val deleteNoteUseCase: DeleteNoteUseCase by inject()
}