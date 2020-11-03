package com.evaluation.book.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.evaluation.adapter.viewholder.item.BaseItemView
import com.evaluation.book.interaction.AppBooksInteraction


/**
 * @author Vladyslav Havrylenko
 * @since 07.10.2020
 */
class BookViewModel @ViewModelInject constructor(
    private val interaction: AppBooksInteraction
) : ViewModel() {

    val refresh = MutableLiveData<Boolean>()
    private val trigger = MutableLiveData<Unit>()

    val result: LiveData<MutableList<BaseItemView>> =
        trigger.switchMap {
            LiveDataReactiveStreams.fromPublisher(interaction.bookList()).map {
                ready()
                it
            }
        }

    init {
        load()
    }

    private fun trigger() {
        trigger.value = Unit
    }

    private fun load() {
        refresh.value = true
        trigger()
    }

    private fun ready() {
        refresh.value = false
    }

    fun listener(): SwipeRefreshLayout.OnRefreshListener =
        SwipeRefreshLayout.OnRefreshListener { load() }

}