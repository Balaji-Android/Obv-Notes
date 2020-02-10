package com.balaji.obvnotes.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.balaji.obvnotes.R
import com.balaji.obvnotes.databinding.ActivityCreateNotesBinding
import com.balaji.obvnotes.databinding.ActivityViewNotesBinding
import com.balaji.obvnotes.entities.NotesEntity
import com.balaji.obvnotes.viewModels.CreateNotesViewModel
import com.balaji.obvnotes.viewModels.ViewNotesViewModel

class ViewNotesActivity : AppCompatActivity() {

    private val viewModel by viewModels<ViewNotesViewModel>()
    private lateinit var binding: ActivityViewNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_notes)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        initials()
    }

    private fun initials() {

        title = "View Notes"
        intent.extras?.let { viewModel.setData(it) }

    }
}
