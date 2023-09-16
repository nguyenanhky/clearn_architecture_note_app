package com.devcomentry.noteapp.presenter.notes

import com.devcomentry.noteapp.demain.model.Note


sealed class NoteEvent {
    data class DeleteNote(val note: Note) : NoteEvent()
    object RestoreNote : NoteEvent()
}