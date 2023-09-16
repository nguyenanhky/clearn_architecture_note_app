package com.devcomentry.noteapp.presenter.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcomentry.noteapp.demain.model.Note
import com.devcomentry.noteapp.demain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases,
) : ViewModel() {
    private val _notesState = mutableStateOf(emptyList<Note>())
    val notesState: State<List<Note>>
        get() = _notesState

    private var job: Job? = null
    private var deleteNote: Note? = null

    init {
        getNotes()
    }

    fun onEvent(event: NoteEvent) {
        if (event is NoteEvent.DeleteNote) {
            viewModelScope.launch {
                noteUseCases.deleteNote(event.note)
            }
            deleteNote = event.note
        } else {
            viewModelScope.launch {
                noteUseCases.addNote(deleteNote!!)
            }
        }
    }

    private fun getNotes() {
        job?.cancel()
        job = noteUseCases.getNotes().onEach {
            _notesState.value = it
        }.launchIn(viewModelScope)

    }
}