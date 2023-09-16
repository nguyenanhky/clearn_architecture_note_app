package com.devcomentry.noteapp.presenter.notes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.devcomentry.noteapp.demain.model.Note

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    onDelete: () -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .matchParentSize()
                .padding(8.dp)
                .padding(32.dp)
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                maxLines = 1
            )
            Text(
                text = note.title,
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                maxLines = 5
            )
        }
        IconButton(modifier = Modifier.align(Alignment.CenterEnd), onClick = onDelete) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = null)
        }
    }
}