package com.devcomentry.noteapp.demain.repositoery

import com.devcomentry.noteapp.demain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes():Flow<List<Note>>

    suspend fun addNote(note:Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun getNote(id:Int):Note?
}