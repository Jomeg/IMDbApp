package com.example.josebootcampandroid.data.di

import android.content.Context
import androidx.room.Room
import com.example.josebootcampandroid.data.datasource.database.MovieDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun providerRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MovieDb::class.java, "MovieDb").build()

    @Singleton
    @Provides
    fun providerDao(movieDb: MovieDb) = movieDb.movieDao()
}


