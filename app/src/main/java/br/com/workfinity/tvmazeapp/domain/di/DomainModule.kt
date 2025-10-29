package br.com.workfinity.tvmazeapp.domain.di

import br.com.workfinity.tvmazeapp.domain.repository.TvMazeRepository
import br.com.workfinity.tvmazeapp.domain.usecase.GetAllShowsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideGetAllShowsUseCase(repository: TvMazeRepository) =
        GetAllShowsUseCaseImpl(repository = repository)
}