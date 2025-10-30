package br.com.workfinity.tvmazeapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.workfinity.tvmazeapp.data.local.relationship.ShowWithGenresAndImage
import br.com.workfinity.tvmazeapp.domain.model.Show

@Entity(tableName = "shows")
data class ShowEntity(
    @PrimaryKey val id: Int,
    val url: String,
    val name: String,
    val type: String,
    val language: String,
    val status: String,
    val summary: String,
)

fun ShowWithGenresAndImage.toModel() = Show(
    id = showEntity.id,
    url = showEntity.url,
    name = showEntity.name,
    type = showEntity.type,
    language = showEntity.language,
    genres = genres.map { it.genre },
    status = showEntity.status,
    image = image.toModel(),
    summary = showEntity.summary
)
