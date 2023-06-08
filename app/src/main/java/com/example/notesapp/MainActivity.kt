package com.example.notesapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.model.Note
import java.util.Date

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = NotesAdapter(
            navigateToCheckBoxDetailsScreen = ::navigateToCheckBoxDetailsScreen,
            navigateToSimpleDetailsScreen = ::navigateToSimpleDetailsScreen
        )

        val simpleNote = Note(
            title = "Joseph",
            descriptor = "fi43if34onfn34fio3infn3io4",
            isSimpleNote = true,
            checkBoxIsCheckedList = emptyList(),
            checkBoxtitleList = emptyList(),
            lastEditedDate = Date()
        )

        val checkNote = Note(
            title = "Joseph233",
            descriptor = "",
            isSimpleNote = false,
            checkBoxIsCheckedList = listOf(
                true,
                true,
                true,
                false,
                true,
                true,
            ),
            checkBoxtitleList = listOf(
                "ded33de3d",
                "e3e3e3",
                "ded33de3d",
                "ded33deee3d",
                "e3e3",
                "ded33de3d",
            ),
            lastEditedDate = Date()
        )
        adapter.updateList(listOf(simpleNote, checkNote))
        binding.recyclerView.adapter = adapter
    }

    private fun navigateToCheckBoxDetailsScreen(note: Note) {
        val intent = Intent(this,CheckNotesDetailsActivity::class.java)
        intent.putExtra(NOTE_KEY,note)
        startActivity(intent)
    }

    private fun navigateToSimpleDetailsScreen(note: Note) {
        val intent = Intent(this,SimpleNoteDetailsActivity::class.java)
        intent.putExtra(NOTE_KEY,note)
        startActivity(intent)
    }
}
const val NOTE_KEY = "NOTE_KEY"