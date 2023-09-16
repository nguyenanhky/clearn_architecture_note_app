package com.devcomentry.noteapp.demain.use_case

import com.devcomentry.noteapp.demain.repositoery.NoteRepository

class GetNote(
    private val noteRepository: NoteRepository,
) {
    suspend operator fun invoke(id: Int) = noteRepository.getNote(id)
}