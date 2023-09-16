package com.devcomentry.noteapp.di

import androidx.room.Room
import com.devcomentry.noteapp.NoteApplication
import com.devcomentry.noteapp.data.data_source.NoteDatabase
import com.devcomentry.noteapp.data.repositoery.NoteRepositoryImpl
import com.devcomentry.noteapp.demain.repositoery.NoteRepository
import com.devcomentry.noteapp.demain.use_case.AddNote
import com.devcomentry.noteapp.demain.use_case.DeleteNote
import com.devcomentry.noteapp.demain.use_case.GetNote
import com.devcomentry.noteapp.demain.use_case.GetNotes
import com.devcomentry.noteapp.demain.use_case.NoteUseCases
import com.devcomentry.noteapp.demain.use_case.UpdateNote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton


@Module
@InstallIn(Singleton::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(application: NoteApplication): NoteDatabase = Room.databaseBuilder(
        application,
        NoteDatabase::class.java,
        NoteDatabase.DB_NAME
    ).build()

    @Provides
    @Singleton
    fun provideNoteRepository(noteDatabase: NoteDatabase): NoteRepository =
        NoteRepositoryImpl(noteDao = noteDatabase.noteDao)

    @Provides
    @Singleton
    fun provideNoteUses(noteRepository: NoteRepository):NoteUseCases = NoteUseCases(
        addNote = AddNote(noteRepository),
        updateNote = UpdateNote(noteRepository),
        deleteNote = DeleteNote(noteRepository),
        getNotes = GetNotes(noteRepository),
        getNote = GetNote(noteRepository)
    )


}
