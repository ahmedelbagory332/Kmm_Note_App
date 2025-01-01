package com.example.kmmnoteapp

import com.example.kmmnoteapp.data.local.NoteDataBase
import org.koin.dsl.module

val databaseModule = module {
    single { provideDatabase(context = null) }
}

expect fun provideDatabase(context: Any? = null): NoteDataBase