package com.yurnero.noteapp.feature.domain.use_case

import com.yurnero.noteapp.feature.data.repository.FakeRepository
import com.yurnero.noteapp.feature.domain.model.Note
import com.yurnero.noteapp.feature.domain.repository.NoteRepository
import com.yurnero.noteapp.feature.domain.util.NoteOrder
import com.yurnero.noteapp.feature.domain.util.OrderType
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetNotesTest {
    private lateinit var fakeRepository: NoteRepository
    private lateinit var getNotes: GetNotes

    @Before
    fun setUp() {
        fakeRepository = FakeRepository()
        getNotes = GetNotes(fakeRepository)

        val notesToInsert = mutableListOf<Note>()

        ('a'..'h').forEachIndexed { index, c ->
            notesToInsert.add(
                Note(
                    title = c.toString(),
                    content = c.toString(),
                    timestamp = index.toLong(),
                    color = index
                )
            )
        }
        //need shuffle
//        notesToInsert.shuffle()
        runBlocking {
            notesToInsert.forEach { fakeRepository.insertNote(it) }
        }
    }

    @Test
    fun `Order notes by timestamp descending, correct order`() = runBlocking {
        val notes = getNotes(NoteOrder.Date(OrderType.Descending)).first()

        for (i in 0..notes.size - 2) {
            assert(notes[i].timestamp < notes[i + 1].timestamp)
        }
    }
}