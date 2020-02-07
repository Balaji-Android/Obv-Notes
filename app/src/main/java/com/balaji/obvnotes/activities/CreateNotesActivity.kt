package com.balaji.obvnotes.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.balaji.obvnotes.viewModels.CreateNotesViewModel
import com.balaji.obvnotes.R

class CreateNotesActivity : AppCompatActivity() {

    private val viewModel by viewModels<CreateNotesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_notes)
    }
}
