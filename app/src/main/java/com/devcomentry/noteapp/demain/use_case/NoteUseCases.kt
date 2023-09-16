package com.devcomentry.noteapp.demain.use_case

data class NoteUseCases(
    val addNote: AddNote,
    val updateNote: UpdateNote,
    val deleteNote: DeleteNote,
    val getNotes: GetNotes,
    val getNote: GetNote
)