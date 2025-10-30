package br.com.workfinity.tvmazeapp.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "show_genres",
    primaryKeys = ["showId", "genre"],
    foreignKeys = [ForeignKey(
        entity = ShowEntity::class,
        parentColumns = ["id"],
        childColumns = ["showId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class ShowGenreEntity(
    val showId: Int,
    val genre: String
)