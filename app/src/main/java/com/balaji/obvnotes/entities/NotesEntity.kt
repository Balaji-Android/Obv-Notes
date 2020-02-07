package com.balaji.obvnotes.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NotesEntity(
    @PrimaryKey val createdAt: Long,
    val title: String,
    val notes: String
)