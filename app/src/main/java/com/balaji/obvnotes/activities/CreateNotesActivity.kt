package com.balaji.obvnotes.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.balaji.obvnotes.viewModels.CreateNotesViewModel
import com.balaji.obvnotes.R
import com.balaji.obvnotes.databinding.ActivityCreateNotesBinding

class CreateNotesActivity : AppCompatActivity() {

    private val viewModel by viewModels<CreateNotesViewModel>()
    private lateinit var binding: ActivityCreateNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_notes)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.edtNotes.movementMethod = ScrollingMovementMethod()

        initials()

        onClicks()
    }

    private fun initials() {

        if (intent.hasExtra("notes")) {
            title = "View Notes"
            binding.edtTitle.isEnabled = false
            binding.edtNotes.isEnabled = false
            binding.btnLogin.visibility = View.GONE
            binding.tvTime.visibility = View.VISIBLE
        } else {
            title = "Add Notes"
        }

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
        binding.edtTitle.requestFocus()
        binding.edtTitle.setText("")
        binding.edtNotes.setText("")
    }

    private fun showToast(msg: String, toastDuration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, msg, toastDuration).show()
    }
}
