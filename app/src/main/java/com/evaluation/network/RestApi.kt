package com.evaluation.network

import com.evaluation.book.model.item.rest.BookList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("volumes")
    fun bookList(
        @Query("q") query: String,
    ): Single<BookList>

}