package com.example.daggerhilt.ui.module

import android.content.Context
import androidx.room.Room
import com.example.daggerhilt.room.Db
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyModule {

    /** Tells dagger to provide the instance of as following function */

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(
            app,
            Db::class.java,
            "dbData"
        ).build()

    @Singleton
    @Provides
    fun provideDeliver(db: Db) = db.deliver()
}