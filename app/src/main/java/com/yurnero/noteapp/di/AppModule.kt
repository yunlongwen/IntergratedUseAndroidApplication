package com.yurnero.noteapp.di

import android.app.Application
import androidx.room.Room
import com.yurnero.noteapp.feature.data.data_source.NoteDatabase
import com.yurnero.noteapp.feature.data.repository.NoteRepositoryImpl
import com.yurnero.noteapp.feature.domain.repository.NoteRepository
import com.yurnero.noteapp.feature.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providerNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providerNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun providerNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            getNote = GetNote(repository),
            addOrUpdateNote = AddOrUpdateNote(repository),
            deleteNote = DeleteNote(repository)
        )
    }
}