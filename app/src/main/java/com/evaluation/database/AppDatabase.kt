package com.evaluation.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.evaluation.book.database.AppDatabaseDao
import com.evaluation.book.model.item.database.BookTableItem
import com.evaluation.utils.DATABASE_VERSION

@Database(entities = [BookTableItem::class], version = DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appBooksDao(): AppDatabaseDao

}






