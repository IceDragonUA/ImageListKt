package com.evaluation.book.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.evaluation.book.model.item.database.BookTableItem
import io.reactivex.Single

@Dao
interface AppDatabaseDao {

    @Query("SELECT * FROM books ORDER BY `index` ASC")
    fun bookList(): Single<List<BookTableItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(book: BookTableItem)

}