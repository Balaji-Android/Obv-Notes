package com.balaji.obvnotes.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.balaji.obvnotes.entities.NotesEntity

@Dao
interface NotesDao {

    @Insert
    suspend fun insertNotes(user: NotesEntity)

    @Query("SELECT * from notes ORDER BY createdAt DESC")
    fun getNotes(): LiveData<List<NotesEntity>>

}