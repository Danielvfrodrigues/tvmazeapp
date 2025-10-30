package br.com.workfinity.tvmazeapp.data.remote.repository

import br.com.workfinity.tvmazeapp.data.local.dao.TvMazeDao
import br.com.workfinity.tvmazeapp.data.remote.TvMazeApiService
import br.com.workfinity.tvmazeapp.data.remote.dto.toEntity
import br.com.workfinity.tvmazeapp.data.remote.dto.toModel
import br.com.workfinity.tvmazeapp.domain.model.Show
import br.com.workfinity.tvmazeapp.domain.repository.TvMazeRepository
import okio.IOException

class TvMazeRepositoryImpl(
    private val api: TvMazeApiService,
    private val dao: TvMazeDao,
) : TvMazeRepository {
    override suspend fun getAllShows(): Result<List<Show>> {
        val response = api.getAllShows()
        return when {
            response.isSuccessful -> {
                val responseBody = response.body().orEmpty()

                runCatching {
                    responseBody.forEach { dao.insertShow(it.toEntity()) }
                }.fold(
                    onSuccess = { Result.success(responseBody.map { it.toModel() }) },
                    onFailure = { Result.failure(IOException("Error: Failed to insert on database", it)) }
                )
            }

            else -> Result.failure(Exception("Error ${response.code()}: ${response.message()}"))
        }
    }
}