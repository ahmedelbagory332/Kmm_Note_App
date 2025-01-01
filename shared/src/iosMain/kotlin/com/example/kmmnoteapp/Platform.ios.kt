package com.example.kmmnoteapp

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.kmmnoteapp.data.local.NoteDataBase
import platform.Foundation.NSHomeDirectory

fun provideDatabase(context: Any?): NoteDataBase {
    val dbFile = NSHomeDirectory() + "/note.db"
    return Room.databaseBuilder<NoteDataBase>(
        name = dbFile,
        factory = { NoteDataBase::class.instantiateImpl()}
    ).setDriver(BundledSQLiteDriver()).build()
}