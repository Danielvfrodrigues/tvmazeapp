package br.com.workfinity.tvmazeapp.data.remote.repository

import br.com.workfinity.tvmazeapp.data.remote.TvMazeApiService
import br.com.workfinity.tvmazeapp.data.remote.dto.toModel
import br.com.workfinity.tvmazeapp.domain.model.Show
import br.com.workfinity.tvmazeapp.domain.repository.TvMazeRepository

class TvMazeRepositoryImpl(
    private val api: TvMazeApiService,
) : TvMazeRepository {
    override suspend fun getAllShows(): Result<List<Show>> {
        val response = api.getAllShows()
        return when {
            response.isSuccessful -> Result.success(response.body()?.map { it.toModel() }.orEmpty())
            else -> Result.failure(Exception("Error ${response.code()}: ${response.message()}"))
        }
    }
}