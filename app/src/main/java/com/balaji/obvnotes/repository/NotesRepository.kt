package com.balaji.obvnotes.repository

import androidx.lifecycle.LiveData
import com.balaji.obvnotes.dao.NotesDao
import com.balaji.obvnotes.entities.NotesEntity

class NotesRepository(private val notesDao: NotesDao) {

    suspend fun insertNotes(notesEntity: NotesEntity) {
        notesDao.insertNotes(notesEntity)
    }

    fun getNotes(): LiveData<List<NotesEntity>> {
        return notesDao.getNotes()
    }

}