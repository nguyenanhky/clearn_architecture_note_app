package com.devcomentry.noteapp.presenter.notes

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch


@Composable
fun NotesScreen(
    navController: NavController,
    notesViewModel: NoteViewModel = hiltViewModel(),
) {
    val notes = notesViewModel.notesState.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                content = {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            )

        },
        scaffoldState = scaffoldState
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(notes) { note ->
                NoteItem(note = note, modifier = Modifier.fillMaxWidth(), onDelete = {
                    notesViewModel.onEvent(NoteEvent.DeleteNote(note))
                    scope.launch {
                        var result = scaffoldState.snackbarHostState.showSnackbar(
                            "Note Deleted",
                        "Undo"
                        )
                        if(result==SnackbarResult.ActionPerformed){
                            notesViewModel.onEvent(NoteEvent.RestoreNote)
                        }
                    }
                })
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NotesScreenPreview(){
    NotesScreen(navController = rememberNavController())
}

