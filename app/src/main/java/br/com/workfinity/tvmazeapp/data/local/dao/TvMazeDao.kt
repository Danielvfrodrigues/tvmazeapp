package br.com.workfinity.tvmazeapp.data.local.dao

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import br.com.workfinity.tvmazeapp.data.local.entity.ShowEntity

interface TvMazeDao {

    @Upsert
    suspend fun insertShow(showEntity: ShowEntity)

    @Delete
    suspend fun deleteShow(showEntity: ShowEntity)

    @Query("SELECT * FROM shows")
    suspend fun getAllShows()

    @Query("SELECT * FROM shows WHERE id = :id")
    suspend fun getShowById(id: Int)
}