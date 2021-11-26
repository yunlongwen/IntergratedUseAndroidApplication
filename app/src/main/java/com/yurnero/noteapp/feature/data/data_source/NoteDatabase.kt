package com.yurnero.noteapp.feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yurnero.noteapp.feature.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "note_db"
    }
}