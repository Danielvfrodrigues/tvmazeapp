package br.com.workfinity.tvmazeapp.data.remote

import br.com.workfinity.tvmazeapp.data.remote.dto.ShowDto
import retrofit2.Response
import retrofit2.http.GET

interface TvMazeApiService {

    @GET("shows")
    suspend fun getAllShows(): Response<List<ShowDto>>
}
