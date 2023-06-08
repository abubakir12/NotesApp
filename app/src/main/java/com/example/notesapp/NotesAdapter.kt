package com.example.notesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.CheckNoteItemBinding
import com.example.notesapp.databinding.SimpleNoteBinding
import com.example.notesapp.model.Note

@Suppress("UNREACHABLE_CODE")
class NotesAdapter(
    private val navigateToSimpleDetailsScreen: (note: Note) -> Unit,
    private val navigateToCheckBoxDetailsScreen: (note: Note) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val notesList = mutableListOf<Note>()

    fun updateList(newList: List<Note>) {
        notesList.clear()
        notesList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class SimpleNoteViewHolder(
        private val binding: SimpleNoteBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(note: Note) {
            binding.title.text = note.title
            // binding.titleText.text = note.tit
            binding.lastEditedTextView.text = "Last edited" + note.lastEditedDate.toString()

            binding.root.setOnClickListener {
                navigateToSimpleDetailsScreen(note)
            }
        }
    }

    inner class CheckNoteViewHolder(
        private val binding: CheckNoteItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(note: Note) {
            binding.titleTextView.text = note.title
            binding.lastEditedTextView.text = "Last edited" + note.lastEditedDate.toString()
            binding.root.setOnClickListener {
                navigateToCheckBoxDetailsScreen(note)
            }
            note.checkBoxIsCheckedList.forEachIndexed { index, value ->
                when (index) {
                    0 -> {
                        binding.firstCheckBox.isChecked = value
                        binding.firstCheckBoxTitle.text = note.checkBoxtitleList[index]
                    }

                    1 -> {
                        binding.secondCheckBox.isChecked = value
                        binding.secondCheckBoxTitle.text = note.checkBoxtitleList[index]
                    }

                    2 -> {
                        binding.thirdCheckBox.isChecked = value
                        binding.thirdCheckBoxTitle.text = note.checkBoxtitleList[index]
                    }

                    3 -> {
                        binding.fourCheckBox.isChecked = value
                        binding.fourCheckBoxTitle.text = note.checkBoxtitleList[index]
                    }

                    4 -> {
                        binding.fifthCheckBox.isChecked = value
                        binding.fifthCheckBoxTitle.text = note.checkBoxtitleList[index]
                    }

                    5 -> {
                        binding.sixCheckBox.isChecked = value
                        binding.sixCheckBoxTitle.text = note.checkBoxtitleList[index]
                    }
                }

            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        return when (viewType) {
            0 -> {
                val view = inflater.inflate(
                    R.layout.simple_note_,
                    parent,
                    false
                )
                val binding = SimpleNoteBinding.bind(view)
                val viewHolder = SimpleNoteViewHolder(binding)
                viewHolder
            }

            else -> {
                val view = inflater.inflate(
                    R.layout.check_note_item,
                    parent,
                    false
                )
                val binding = CheckNoteItemBinding.bind(view)
                val viewHolder = CheckNoteViewHolder(binding)
                viewHolder
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val note = notesList[position]
        return if (note.isSimpleNote) 0 else 1
    }

    override fun getItemCount(): Int = notesList.size

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        if (notesList[position].isSimpleNote) {
            (holder as SimpleNoteViewHolder).bind(notesList[position])
        } else {
            (holder as CheckNoteViewHolder).bind(notesList[position])

        }
    }
}