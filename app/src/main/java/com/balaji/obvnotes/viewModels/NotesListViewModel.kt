package com.balaji.obvnotes.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.balaji.obvnotes.database.NotesDatabase
import com.balaji.obvnotes.entities.NotesEntity
import com.balaji.obvnotes.repository.NotesRepository

class NotesListViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var notesList: LiveData<List<NotesEntity>>
    private val notesRepository: NotesRepository

    init {
        val notesDao = NotesDatabase.getDatabase(application).notesDao()
        notesRepository = NotesRepository(notesDao)
    }

    fun fetchNotes() {
        notesList = notesRepository.getNotes()
    }
}