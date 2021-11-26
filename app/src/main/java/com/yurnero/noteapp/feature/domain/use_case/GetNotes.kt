package com.yurnero.noteapp.feature.domain.use_case

import com.yurnero.noteapp.feature.domain.model.Note
import com.yurnero.noteapp.feature.domain.repository.NoteRepository
import com.yurnero.noteapp.feature.domain.util.NoteOrder
import com.yurnero.noteapp.feature.domain.util.OrderType
import kotlinx.coroutines.flow.Flow

class GetNotes(private val repository: NoteRepository) {
    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>> {
        return repository.getNotes()
    }

}
