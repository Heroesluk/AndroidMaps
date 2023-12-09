package com.example.myapplication.di


import android.app.Application
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.Database
import com.example.myapplication.data.PlaceDataSource
import com.example.myapplication.data.PlaceDataSourceImp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): AndroidSqliteDriver {
        return AndroidSqliteDriver(
            schema = Database.Schema,
            context = app,
            name = "Database.db"
        )
    }

    @Provides
    @Singleton
    fun providePersonDataSource(driver: AndroidSqliteDriver): PlaceDataSource {
        return PlaceDataSourceImp(Database(driver))
    }
}