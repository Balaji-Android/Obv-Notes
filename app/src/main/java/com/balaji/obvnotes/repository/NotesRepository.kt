package com.balaji.obvnotes.repository

import com.balaji.obvnotes.dao.NotesDao
import com.balaji.obvnotes.entities.NotesEntity

class NotesRepository(private val notesDao: NotesDao) {

    suspend fun insertNotes(notesEntity: NotesEntity) {
        notesDao.insertNotes(notesEntity)
    }

    suspend fun getAllNotes(): List<NotesEntity> {
        return notesDao.getAllNotes()
    }

}