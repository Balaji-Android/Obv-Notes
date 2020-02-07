package com.balaji.obvnotes.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.balaji.obvnotes.R
import com.balaji.obvnotes.database.NotesDatabase
import com.balaji.obvnotes.entities.NotesEntity
import com.balaji.obvnotes.repository.NotesRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateNotesViewModel(application: Application) : AndroidViewModel(application) {

    private val notesRepository: NotesRepository

    var title: String = ""
    var notes: String = ""

    init {
        val notesDao = NotesDatabase.getDatabase(application).notesDao()
        notesRepository = NotesRepository(notesDao)
    }

    fun insertNotes() = viewModelScope.launch {
        val notesEntity = NotesEntity(System.currentTimeMillis(), title, notes)
        notesRepository.insertNotes(notesEntity)
    }

    fun insertFieldsValidation(): Any {
        return when {
            title.isEmpty() -> R.string.msg_enter_title
            notes.isEmpty() -> R.string.msg_enter_notes
            else -> true
        }
    }
}