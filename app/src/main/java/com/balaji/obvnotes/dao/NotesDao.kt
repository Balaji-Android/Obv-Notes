package com.balaji.obvnotes.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.balaji.obvnotes.entities.NotesEntity

@Dao
interface NotesDao {

    @Insert
    suspend fun insertNotes(user: NotesEntity)

    @Query("SELECT * from notes")
    suspend fun getAllNotes(): List<NotesEntity>

}