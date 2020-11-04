package com.evaluation.book.repository

import android.content.Context
import com.evaluation.R
import com.evaluation.adapter.viewholder.item.BaseItemView
import com.evaluation.book.adapter.viewholder.item.CardItemView
import com.evaluation.adapter.viewholder.item.NoItemView
import com.evaluation.book.database.AppDatabaseDao
import com.evaluation.book.mapper.BookMapper
import com.evaluation.book.network.AppRestApiDao
import com.evaluation.utils.defIfNull
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * @author Vladyslav Havrylenko
 * @since 01.05.2020
 */
class AppBooksRepositoryImpl @Inject constructor(
    private val context: Context,
    private val mapper: BookMapper,
    private val appRestApiDao: AppRestApiDao,
    private val appDatabaseDao: AppDatabaseDao
) : AppBooksRepository {

    override fun bookList(): Single<MutableList<BaseItemView>> {
        return appRestApiDao.bookList()
            .map {
                it.items.mapIndexed { index, volume ->
                    appDatabaseDao.insert(mapper.toTableItem(volume, index))
                }
                it.items
            }
            .flatMap {
                bookListFromDB()
            }
            .onErrorResumeNext {
                bookListFromDB()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            }
    }

    private fun bookListFromDB(): Single<MutableList<BaseItemView>> {
        return appDatabaseDao.bookList()
            .map {
                val itemList: MutableList<BaseItemView> = mutableListOf()
                it.forEach { item ->
                    itemList.add(CardItemView(id = item.id, book = item))
                }
                itemList.ifEmpty {
                    itemList.add(
                        NoItemView(
                            title = context.resources.getString(R.string.result).defIfNull()
                        )
                    )
                }
                itemList
            }
    }
}
