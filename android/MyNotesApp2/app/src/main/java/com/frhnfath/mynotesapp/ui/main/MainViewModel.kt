package com.frhnfath.mynotesapp.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.frhnfath.mynotesapp.database.Note
import com.frhnfath.mynotesapp.repository.NoteRepository

class MainViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()
}