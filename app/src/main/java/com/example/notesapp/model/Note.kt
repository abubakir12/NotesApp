package com.example.notesapp.model

import android.provider.ContactsContract.RawContacts.Data
import java.io.Serializable
import java.util.Date

data class Note(
    //данные для Simple note item
    val title: String,
    val descriptor: String,
    val lastEditedDate: Date,

    val isSimpleNote: Boolean,

    //данные для Check box note item
    val checkBoxIsCheckedList:List<Boolean>,
    val checkBoxtitleList:List<String>

):Serializable
