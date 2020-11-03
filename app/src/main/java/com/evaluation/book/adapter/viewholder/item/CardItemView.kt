package com.evaluation.book.adapter.viewholder.item

import com.evaluation.adapter.factory.TypesFactory
import com.evaluation.adapter.viewholder.item.BaseItemView
import com.evaluation.book.model.item.database.BookTableItem

/**
 * @author Vladyslav Havrylenko
 * @since 03.10.2020
 */
data class CardItemView(override var id: String, var book: BookTableItem) : BaseItemView {

    override fun type(typesFactory: TypesFactory): Int = typesFactory.type(this)

}