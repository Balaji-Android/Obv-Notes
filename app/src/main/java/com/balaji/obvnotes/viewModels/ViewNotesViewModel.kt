package com.balaji.obvnotes.viewModels

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.balaji.obvnotes.Constants
import com.balaji.obvnotes.entities.NotesEntity
import java.text.SimpleDateFormat
import java.util.*

class ViewNotesViewModel : ViewModel() {

    var title: String = ""
    var notes: String = ""
    var time: String = ""

    fun setData(bundle: Bundle) {
        val notesEntity: NotesEntity = bundle.getSerializable(Constants.keyNotes) as NotesEntity
        title = notesEntity.title
        notes = notesEntity.notes
        time = getDateTime(notesEntity.createdAt)
    }

    private fun getDateTime(s: Long): String {
        return try {
            val sdf = SimpleDateFormat(Constants.timeFormat)
            val netDate = Date(s)
            sdf.format(netDate)
        } catch (e: Exception) {
            e.toString()
        }
    }
}