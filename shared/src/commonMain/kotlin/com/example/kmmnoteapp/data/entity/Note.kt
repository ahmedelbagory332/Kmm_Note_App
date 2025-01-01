package com.example.kmmnoteapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val content: String,
    val color: Int,
    val dateCreated: String
)
