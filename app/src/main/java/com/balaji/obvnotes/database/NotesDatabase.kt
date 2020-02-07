package com.balaji.obvnotes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.balaji.obvnotes.dao.NotesDao
import com.balaji.obvnotes.entities.NotesEntity

@Database(entities = [NotesEntity::class], version = 1)
public abstract class NotesDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDao

    companion object {

        @Volatile
        private var INSTANCE: NotesDatabase? = null

        fun getDatabase(context: Context): NotesDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    "obv_notes_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}