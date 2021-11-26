package com.yurnero.noteapp.feature.domain.use_case

data class NoteUseCases(
    val getNotes: GetNotes,
    val getNote: GetNote,
    val addOrUpdateNote: AddOrUpdateNote,
    val deleteNote: DeleteNote
)
