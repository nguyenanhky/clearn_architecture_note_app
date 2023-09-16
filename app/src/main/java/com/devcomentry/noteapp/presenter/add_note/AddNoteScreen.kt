package com.devcomentry.noteapp.presenter.add_note

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.devcomentry.noteapp.presenter.update_note.AddEditNoteEvent

@Composable
fun AddNoteScreen(
    navController: NavController,
    addNoteViewModel: AddNoteViewModel = hiltViewModel()
) {
    val title = addNoteViewModel.title.value
    val content = addNoteViewModel.content.value
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (title.isBlank()) {
                        Toast.makeText(context, "title  is empty", Toast.LENGTH_SHORT).show()
                        return@FloatingActionButton
                    }
                    if (content.isBlank()) {
                        Toast.makeText(context, "content  is empty", Toast.LENGTH_SHORT).show()
                        return@FloatingActionButton

                    }
                    addNoteViewModel.onEvent(AddEditNoteEvent.SaveNote)
                    navController.navigateUp()
                },
                content = {
                    Icon(imageVector = Icons.Default.Save, contentDescription = null)
                }
            )

        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            OutlinedTextField(
                value = title,
                onValueChange = {
                    addNoteViewModel.onEvent(AddEditNoteEvent.EnteredTitle(it))
                },
                label = {
                    Text(text = "Title")
                },
                textStyle = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth()

            )
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = content,
                onValueChange = {
                    addNoteViewModel.onEvent(AddEditNoteEvent.EnterContent(it))
                },
                label = {
                    Text(text = "Content")
                },
                textStyle = MaterialTheme.typography.body1,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 60.dp)

            )
        }

    }
}