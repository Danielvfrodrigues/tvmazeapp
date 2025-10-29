package br.com.workfinity.tvmazeapp.domain.repository

import br.com.workfinity.tvmazeapp.domain.model.Show

interface TvMazeRepository {
    suspend fun getAllShows(): Result<List<Show>>
}