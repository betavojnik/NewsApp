package com.androiddevs.mvvmnewsapp.ui.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.androiddevs.mvvmnewsapp.ui.model.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converter::class)
abstract class articleDB : RoomDatabase() {

    abstract fun getArticleDao(): articleDAO

    companion object {
        @Volatile
        private var instance: articleDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                 articleDB::class.java,
                 "article_db.db"

            ).build()

        }
    }