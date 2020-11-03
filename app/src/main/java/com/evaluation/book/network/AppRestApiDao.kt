package com.evaluation.book.network

import com.evaluation.book.model.item.rest.BookList
import com.evaluation.utils.QUERY
import io.reactivex.Single

interface AppRestApiDao {

    fun bookList(query: String = QUERY): Single<BookList>

}