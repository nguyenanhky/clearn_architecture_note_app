package com.devcomentry.noteapp.presenter.navigation

import com.devcomentry.lib.ComposeScreen

sealed class Screen(_route:String):ComposeScreen(_route) {
    object MainScreen:Screen(_route = "main_screen")
    object AddNoteScreen:Screen(_route = "Add_Note_screen")
    object UpdateNoteScreen:Screen(_route = "Update_Note_screen")
}