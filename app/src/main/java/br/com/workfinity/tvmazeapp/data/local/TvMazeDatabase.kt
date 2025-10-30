package br.com.workfinity.tvmazeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.workfinity.tvmazeapp.data.local.dao.TvMazeDao
import br.com.workfinity.tvmazeapp.data.local.entity.ShowEntity
import br.com.workfinity.tvmazeapp.data.local.entity.ShowGenreEntity
import br.com.workfinity.tvmazeapp.data.local.entity.ShowImageEntity

@Database(
    version = 1,
    entities = [ShowEntity::class, ShowImageEntity::class, ShowGenreEntity::class]
)
abstract class TvMazeDatabase : RoomDatabase() {
    abstract fun tvMazeDao(): TvMazeDao
}