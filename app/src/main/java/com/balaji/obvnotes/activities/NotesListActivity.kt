package com.balaji.obvnotes.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.balaji.obvnotes.NotesAdapter
import com.balaji.obvnotes.R
import com.balaji.obvnotes.databinding.ActivityNotesListBinding
import com.balaji.obvnotes.entities.NotesEntity
import com.balaji.obvnotes.viewModels.NotesListViewModel

class NotesListActivity : AppCompatActivity() {

    private val viewModel by viewModels<NotesListViewModel>()
    private lateinit var binding: ActivityNotesListBinding
    private var notesList: MutableList<NotesEntity> = ArrayList()
    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notes_list)
        binding.lifecycleOwner = this

        setNotesList()

        onClicks()
    }

    private fun setNotesList() {

        adapter = NotesAdapter(notesList, NotesAdapter.ItemClickListener {
            showToast("item clicked")
        })
        binding.rvNotes.adapter = adapter

        viewModel.notesList.observe(this, Observer {
            notesList.clear()
            notesList.addAll(it)
            adapter.notifyDataSetChanged()
            if (notesList.isEmpty())
                binding.tvNoNotes.visibility = View.VISIBLE
            else
                binding.tvNoNotes.visibility = View.GONE
        })

    }

    private fun onClicks() {

        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, CreateNotesActivity::class.java))
        }

    }

    private fun showToast(msg: String, toastDuration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, msg, toastDuration).show()
    }
}
