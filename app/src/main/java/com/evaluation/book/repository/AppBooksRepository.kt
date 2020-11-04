package com.evaluation.book.repository

import com.evaluation.adapter.viewholder.item.BaseItemView
import io.reactivex.Single

/**
 * @author Vladyslav Havrylenko
 * @since 04.11.2020
 */
interface AppBooksRepository {

    fun bookList(): Single<MutableList<BaseItemView>>

}