package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notesapp.databinding.ActivitySimpleNoteDetailsBinding
import com.example.notesapp.model.Note

class SimpleNoteDetailsActivity : AppCompatActivity() {
    private val binding:ActivitySimpleNoteDetailsBinding by lazy{
        ActivitySimpleNoteDetailsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_note_details)
        setContentView(binding.root)
        val note = intent.extras?.getSerializable(NOTE_KEY) as? Note
        initViews(note)
    }
    private fun initViews(note: Note?){
        if (note == null)return
        binding.title.text = title
        binding.noteDescriptionTextView.text = note.descriptor
        binding.lastEditedTextView.text = "Last edited" + note.lastEditedDate.toString()
    }
}