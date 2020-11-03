package com.evaluation.book.interaction

import androidx.annotation.MainThread
import com.evaluation.adapter.viewholder.item.BaseItemView
import com.evaluation.book.repository.AppBooksRepository
import io.reactivex.processors.BehaviorProcessor
import javax.inject.Inject

/**
 * @author Vladyslav Havrylenko
 * @since 09.10.2020
 */
class AppBooksInteractionImpl @Inject constructor(
    private val repository: AppBooksRepository
) : AppBooksInteraction {

    @MainThread
    override fun bookList(): BehaviorProcessor<MutableList<BaseItemView>> {
        val processor = BehaviorProcessor.create<MutableList<BaseItemView>>()
        repository.bookList().toFlowable().subscribe(processor)
        return processor
    }
}
