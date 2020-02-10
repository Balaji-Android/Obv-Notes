package com.balaji.obvnotes.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.balaji.obvnotes.database.NotesDatabase
import com.balaji.obvnotes.repository.NotesRepository

class NotesListViewModel(application: Application) : AndroidViewModel(application) {

    private val notesRepository: NotesRepository

    init {
        val notesDao = NotesDatabase.getDatabase(application).notesDao()
        notesRepository = NotesRepository(notesDao)
    }

    val notesList = liveData {
        emit(notesRepository.getAllNotes())
    }
}