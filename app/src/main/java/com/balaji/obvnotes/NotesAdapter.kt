package com.balaji.obvnotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.balaji.obvnotes.databinding.RowNotesBinding
import com.balaji.obvnotes.entities.NotesEntity

class NotesAdapter(
    private val items: List<NotesEntity>,
    private val clickListener: ItemClickListener
) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RowNotesBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], clickListener)
    }

    class ViewHolder(private val binding: RowNotesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NotesEntity, clickListener: ItemClickListener) {
            binding.item = item
            binding.clickListener = clickListener
        }
    }

    class ItemClickListener(val clickListener: (item: NotesEntity) -> Unit) {
        fun onClick(item: NotesEntity) = clickListener(item)
    }

}