package br.com.workfinity.tvmazeapp.domain.usecase

import br.com.workfinity.tvmazeapp.domain.model.Show
import br.com.workfinity.tvmazeapp.domain.repository.TvMazeRepository

interface GetAllShowsUseCase {
    suspend operator fun invoke(): Result<List<Show>>
}

class GetAllShowsUseCaseImpl(
    private val repository: TvMazeRepository
) : GetAllShowsUseCase {
    override suspend fun invoke(): Result<List<Show>> {
        TODO("Not yet implemented")
    }
}