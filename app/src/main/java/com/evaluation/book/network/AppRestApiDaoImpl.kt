package com.evaluation.book.network

import com.evaluation.network.RestApi
import com.evaluation.book.model.item.rest.BookList
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AppRestApiDaoImpl @Inject constructor(
    private val appRest: RestApi
): AppRestApiDao {

    override fun bookList(query: String): Single<BookList> {
        return appRest.bookList(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}