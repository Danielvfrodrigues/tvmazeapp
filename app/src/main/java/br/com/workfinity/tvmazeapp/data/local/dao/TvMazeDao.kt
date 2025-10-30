package br.com.workfinity.tvmazeapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import br.com.workfinity.tvmazeapp.data.local.entity.ShowEntity
import br.com.workfinity.tvmazeapp.data.local.entity.ShowGenreEntity
import br.com.workfinity.tvmazeapp.data.local.entity.ShowImageEntity
import br.com.workfinity.tvmazeapp.data.local.relationship.ShowWithGenresAndImage

@Dao
interface TvMazeDao {

    @Upsert
    suspend fun insertShow(showEntity: ShowEntity)

    @Upsert
    suspend fun insertImage(imageEntity: ShowImageEntity)

    @Upsert
    suspend fun insertGenres(genres: List<ShowGenreEntity>)

    @Delete
    suspend fun deleteShow(showEntity: ShowEntity)

    @Query("SELECT * FROM shows")
    suspend fun getAllShows(): List<ShowWithGenresAndImage>

    @Query("SELECT * FROM shows WHERE id = :id")
    suspend fun getShowById(id: Int): ShowWithGenresAndImage
}