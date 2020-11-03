package com.evaluation.book.interaction

import com.evaluation.adapter.viewholder.item.BaseItemView
import io.reactivex.processors.BehaviorProcessor

/**
 * @author Vladyslav Havrylenko
 * @since 09.10.2020
 */
interface AppBooksInteraction {

    fun bookList(): BehaviorProcessor<MutableList<BaseItemView>>

}