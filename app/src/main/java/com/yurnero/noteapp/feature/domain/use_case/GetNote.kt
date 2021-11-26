package com.yurnero.noteapp.feature.domain.use_case

import com.yurnero.noteapp.feature.domain.model.Note
import com.yurnero.noteapp.feature.domain.repository.NoteRepository

class GetNote(private val repository: NoteRepository) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}
