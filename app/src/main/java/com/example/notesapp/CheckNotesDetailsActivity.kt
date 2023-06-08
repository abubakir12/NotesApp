package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notesapp.databinding.ActivityCheckNotesDatailsBinding
import com.example.notesapp.model.Note

class CheckNotesDetailsActivity : AppCompatActivity() {

    private val binding: ActivityCheckNotesDatailsBinding by lazy{
        ActivityCheckNotesDatailsBinding.inflate(layoutInflater)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val note = intent.extras?.getSerializable(NOTE_KEY) as? Note
        initView(note)
    }
    private fun initView(note: Note?){
        if (note == null) return
        binding.title.text = title
        binding.lastEditedTextView.text = "Last edited" + note.lastEditedDate.toString()
        binding.firstCheckBox.isChecked = note.checkBoxIsCheckedList[0]
        binding.secondCheckBox.isChecked = note.checkBoxIsCheckedList[1]
        binding.thirdCheckBox.isChecked = note.checkBoxIsCheckedList[2]
        binding.fourCheckBox.isChecked = note.checkBoxIsCheckedList[3]
        binding.fifthCheckBox.isChecked = note.checkBoxIsCheckedList[4]
        binding.sixCheckBox.isChecked = note.checkBoxIsCheckedList[5]
        binding.firstCheckBoxTitle.text = note.checkBoxtitleList[0]
        binding.secondCheckBoxTitle.text = note.checkBoxtitleList[1]
        binding.thirdCheckBoxTitle.text = note.checkBoxtitleList[2]
        binding.fourCheckBoxTitle.text = note.checkBoxtitleList[3]
        binding.fifthCheckBoxTitle.text = note.checkBoxtitleList[4]
        binding.sixCheckBoxTitle.text = note.checkBoxtitleList[5]
    }
}