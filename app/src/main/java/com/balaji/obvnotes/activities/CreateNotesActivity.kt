package com.balaji.obvnotes.activities

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.balaji.obvnotes.Constants
import com.balaji.obvnotes.R
import com.balaji.obvnotes.databinding.ActivityCreateNotesBinding
import com.balaji.obvnotes.viewModels.CreateNotesViewModel

class CreateNotesActivity : AppCompatActivity() {

    private val viewModel by viewModels<CreateNotesViewModel>()
    private lateinit var binding: ActivityCreateNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_notes)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.edtNotes.movementMethod = ScrollingMovementMethod()
        title = getString(R.string.add_notes)

        onClicks()
    }

    private fun onClicks() {

        binding.btnLogin.setOnClickListener {
            when (val result = viewModel.insertFieldsValidation()) {
                is Boolean ->
                    insertNotes()
                is Int ->
                    showToast(getString(result))
            }
        }

    }

    private fun insertNotes() {
        viewModel.insertNotes()
        val intent = Intent(this, ViewNotesActivity::class.java)
        intent.putExtra(Constants.keyNotes, viewModel.notesEntity)
        startActivity(intent)
        finish()
    }

    private fun showToast(msg: String, toastDuration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, msg, toastDuration).show()
    }
}
