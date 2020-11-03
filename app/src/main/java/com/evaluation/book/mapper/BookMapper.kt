package com.evaluation.book.mapper

import com.evaluation.book.model.item.database.BookTableItem
import com.evaluation.book.model.item.rest.Volume
import com.evaluation.utils.defIfNull
import javax.inject.Inject

/**
 * @author Vladyslav Havrylenko
 * @since 01.10.2020
 */
class BookMapper @Inject constructor() {

    fun toTableItem(item: Volume, index: Int): BookTableItem {
        return item.let {
            BookTableItem(
                index = index,
                smallThumbnail = it.volumeInfo.imageLinks.smallThumbnail.defIfNull(),
                thumbnail = it.volumeInfo.imageLinks.smallThumbnail.defIfNull()
            )
        }
    }
}