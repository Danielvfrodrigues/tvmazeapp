package br.com.workfinity.tvmazeapp.data.local.di

import android.content.Context
import androidx.room.Room
import br.com.workfinity.tvmazeapp.data.local.TvMazeDatabase
import br.com.workfinity.tvmazeapp.data.local.dao.TvMazeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataLocalModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TvMazeDatabase =
        Room.databaseBuilder(context, TvMazeDatabase::class.java, "core_db")
            .fallbackToDestructiveMigration(true)
            .build()

    @Provides
    fun provideTvMazeDao(db: TvMazeDatabase): TvMazeDao = db.tvMazeDao()
}