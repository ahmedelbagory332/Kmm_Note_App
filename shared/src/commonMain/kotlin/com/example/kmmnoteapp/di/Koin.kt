package com.example.kmmnoteapp.di


import com.example.kmmnoteapp.data.repo_impl.NoteRepoImpl
import com.example.kmmnoteapp.databaseModule
import com.example.kmmnoteapp.domain.repo.NoteRepo
import com.example.kmmnoteapp.domain.use_case.DeleteNoteUseCase
import com.example.kmmnoteapp.domain.use_case.GetAllNotesUseCase
import com.example.kmmnoteapp.domain.use_case.UpsertNotesUseCase
import org.koin.core.context.startKoin
import org.koin.dsl.module

// for ios
fun initKoin() =
    startKoin {
        modules(commonModule(), databaseModule)
    }

fun commonModule() = module {
    single<NoteRepo> { NoteRepoImpl(get()) }
    single { GetAllNotesUseCase(get()) }
    single { UpsertNotesUseCase(get()) }
    single { DeleteNoteUseCase(get()) }
}