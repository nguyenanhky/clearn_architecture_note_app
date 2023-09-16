package com.devcomentry.noteapp.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.devcomentry.lib.composable
import com.devcomentry.noteapp.presenter.add_note.AddNoteScreen
import com.devcomentry.noteapp.presenter.notes.NotesScreen


@Composable

fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(screen = Screen.MainScreen){
            NotesScreen(navController = navController)
        }

        composable(screen = Screen.AddNoteScreen){
            AddNoteScreen(navController =navController)
        }

    }
}