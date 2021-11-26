package com.yurnero.noteapp.feature.data.repository

import com.yurnero.noteapp.feature.data.data_source.NoteDao
import com.yurnero.noteapp.feature.domain.model.Note
import com.yurnero.noteapp.feature.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val dao: NoteDao) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id = id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note = note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note = note)
    }
}