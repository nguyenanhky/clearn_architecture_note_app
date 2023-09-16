package com.devcomentry.noteapp.data.repositoery

import com.devcomentry.noteapp.data.data_source.NoteDao
import com.devcomentry.noteapp.demain.model.Note
import com.devcomentry.noteapp.demain.repositoery.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val noteDao: NoteDao):NoteRepository {
    override fun getNotes(): Flow<List<Note>> = noteDao.getNote()

    override suspend fun addNote(note: Note) = noteDao.addNote(note = note)

    override suspend fun updateNote(note: Note) = noteDao.updateNote(note = note)

    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)

    override suspend fun getNote(id: Int) = noteDao.getNote(id)

}