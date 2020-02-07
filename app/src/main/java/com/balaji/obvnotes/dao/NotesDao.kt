package com.balaji.obvnotes.dao

import androidx.room.Insert
import androidx.room.Query
import com.balaji.obvnotes.entities.NotesEntity

interface NotesDao {

    @Insert
    suspend fun insertNotes(user: NotesEntity)

    @Query("SELECT * from notes")
    fun getAllNotes(): List<NotesEntity>

}