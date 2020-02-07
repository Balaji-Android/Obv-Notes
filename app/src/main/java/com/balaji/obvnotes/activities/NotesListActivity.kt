package com.balaji.obvnotes.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.balaji.obvnotes.R
import com.balaji.obvnotes.databinding.ActivityCreateNotesBinding
import com.balaji.obvnotes.databinding.ActivityNotesListBinding

class NotesListActivity : AppCompatActivity() {


    private lateinit var binding: ActivityNotesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notes_list)
        binding.lifecycleOwner = this

        onClicks()
    }

    private fun onClicks() {

        binding.fabAdd.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,CreateNotesActivity::class.java))
        })
    }
}
