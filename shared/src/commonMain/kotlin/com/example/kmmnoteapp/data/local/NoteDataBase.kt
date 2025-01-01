package com.example.kmmnoteapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kmmnoteapp.data.entity.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
}