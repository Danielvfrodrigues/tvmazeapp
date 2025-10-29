package br.com.workfinity.tvmazeapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.workfinity.tvmazeapp.domain.model.Show

@Entity(tableName = "shows")
data class ShowEntity(
    @PrimaryKey val id: Int,
    val url: String,
    val name: String,
    val type: String,
    val language: String,
    val genres: List<String>,
    val status: String,
    val image: ShowImageEntity,
    val summary: String,
)

fun ShowEntity.toModel() = Show(
    id = this.id,
    url = this.url,
    name = this.name,
    type = this.type,
    language = this.language,
    genres = this.genres,
    status = this.status,
    image = this.image.toModel(),
    summary = this.summary
)
