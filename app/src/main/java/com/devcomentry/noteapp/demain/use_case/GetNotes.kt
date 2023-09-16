package com.devcomentry.noteapp.demain.use_case

import com.devcomentry.noteapp.demain.repositoery.NoteRepository

class GetNotes(
    private val noteRepository: NoteRepository
) {
    operator fun invoke() = noteRepository.getNotes()
}