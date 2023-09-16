package com.devcomentry.noteapp.presenter.update_note

sealed class AddEditNoteEvent {
    data class EnteredTitle(val title:String): AddEditNoteEvent()
    data class EnterContent(val content:String):AddEditNoteEvent()
    object SaveNote:AddEditNoteEvent()
}