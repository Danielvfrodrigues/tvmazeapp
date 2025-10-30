package br.com.workfinity.tvmazeapp.data.remote.dto

import br.com.workfinity.tvmazeapp.data.local.entity.ShowEntity
import br.com.workfinity.tvmazeapp.domain.model.Show

data class ShowDto(
    val id: Int,
    val url: String,
    val name: String,
    val type: String,
    val language: String,
    val genres: List<String>,
    val status: String,
    val image: ShowImageDto,
    val summary: String,
)

fun ShowDto.toModel() = Show(
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

fun ShowDto.toEntity() = ShowEntity(
    id = this.id,
    url = this.url,
    name = this.name,
    type = this.type,
    language = this.language,
    status = this.status,
    summary = this.summary
)
