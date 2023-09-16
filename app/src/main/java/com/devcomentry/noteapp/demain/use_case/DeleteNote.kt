package com.devcomentry.noteapp.demain.use_case

import com.devcomentry.noteapp.demain.model.Note
import com.devcomentry.noteapp.demain.repositoery.NoteRepository

class DeleteNote(
    private val noteRepository: NoteRepository,
) {
    suspend operator fun invoke(note: Note) = noteRepository.deleteNote(note)

}