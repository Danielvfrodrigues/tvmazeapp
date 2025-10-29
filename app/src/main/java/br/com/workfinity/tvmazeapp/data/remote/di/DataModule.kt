package br.com.workfinity.tvmazeapp.data.remote.di

import br.com.workfinity.tvmazeapp.data.remote.TvMazeApiService
import br.com.workfinity.tvmazeapp.data.remote.repository.TvMazeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providesTvMazeRepository(apiService: TvMazeApiService) = TvMazeRepositoryImpl(
        api = apiService
    )
}
