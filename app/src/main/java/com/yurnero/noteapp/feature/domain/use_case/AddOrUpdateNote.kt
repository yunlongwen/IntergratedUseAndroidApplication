package com.yurnero.noteapp.feature.domain.use_case

import com.yurnero.noteapp.feature.domain.model.Note
import com.yurnero.noteapp.feature.domain.repository.NoteRepository

class AddOrUpdateNote(private val repository: NoteRepository) {

    suspend operator fun invoke(note: Note) {
        repository.insertNote(note)
    }

}
