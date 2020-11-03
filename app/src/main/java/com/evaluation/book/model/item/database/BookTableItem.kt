package com.evaluation.book.model.item.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Vladyslav Havrylenko
 * @since 07.10.2020
 */
@Entity(tableName = "books")
data class BookTableItem(
    @PrimaryKey
    var index: Int,
    val smallThumbnail: String,
    val thumbnail: String
)