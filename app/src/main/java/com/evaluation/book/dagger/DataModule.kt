package com.evaluation.book.dagger

import android.content.Context
import com.evaluation.book.database.AppDatabaseDao
import com.evaluation.book.interaction.AppBooksInteraction
import com.evaluation.book.interaction.AppBooksInteractionImpl
import com.evaluation.book.mapper.BookMapper
import com.evaluation.book.network.AppRestApiDao
import com.evaluation.book.network.AppRestApiDaoImpl
import com.evaluation.book.repository.AppBooksRepository
import com.evaluation.book.repository.AppBooksRepositoryImpl
import com.evaluation.database.AppDatabase
import com.evaluation.network.RestApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun appRest(appRest: RestApi): AppRestApiDao = AppRestApiDaoImpl(appRest)

    @Provides
    @Singleton
    fun appDao(appDatabase: AppDatabase): AppDatabaseDao = appDatabase.appBooksDao()

    @Singleton
    @Provides
    fun appRepository(context: Context, mapper: BookMapper, remoteDao: AppRestApiDao, localDao: AppDatabaseDao) : AppBooksRepository =
        AppBooksRepositoryImpl(context, mapper, remoteDao, localDao)

    @Singleton
    @Provides
    fun appInteraction(repository: AppBooksRepository): AppBooksInteraction =
        AppBooksInteractionImpl(repository)

}