package com.example.tendomini.di

import android.content.Context
import com.example.tendomini.data.datasource.local.db.ApplicationDatabase
import com.example.tendomini.data.datasource.local.db.OrderDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.paperdb.Paper
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideLogDao(database: ApplicationDatabase): OrderDao {
        return database.orderDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ApplicationDatabase {
        return ApplicationDatabase.invoke(appContext)
    }

//    @Provides
//    @Singleton
//    fun providePaperDb(@ApplicationContext appContext: Context) {
//        return Paper.init(appContext)
//    }

}