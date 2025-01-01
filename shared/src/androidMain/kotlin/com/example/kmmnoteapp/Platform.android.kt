package com.example.kmmnoteapp

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.kmmnoteapp.data.local.NoteDataBase
import org.koin.core.module.Module
import org.koin.dsl.module

fun androidModule(context: Context): Module {
    return module {
        single { provideDatabase(context) }
    }
}

actual fun provideDatabase(context: Any?): NoteDataBase {
    require(context is Context) { "Context is required on Android" }

    val dbFile = context.getDatabasePath("note.db")
    return Room.databaseBuilder<NoteDataBase>(
        context = context,
        name = dbFile.absolutePath
    ).setDriver(BundledSQLiteDriver()).build()
}
