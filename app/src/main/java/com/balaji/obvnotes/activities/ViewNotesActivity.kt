package com.balaji.obvnotes.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.balaji.obvnotes.R
import com.balaji.obvnotes.databinding.ActivityViewNotesBinding
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

        title = getString(R.string.view_notes)
        intent.extras?.let { viewModel.setData(it) }

    }
}
