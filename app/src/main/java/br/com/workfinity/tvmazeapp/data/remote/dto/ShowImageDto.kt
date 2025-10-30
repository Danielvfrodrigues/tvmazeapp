package br.com.workfinity.tvmazeapp.data.remote.dto

import br.com.workfinity.tvmazeapp.data.local.entity.ShowImageEntity
import br.com.workfinity.tvmazeapp.domain.model.ShowImage

data class ShowImageDto(
    val medium: String,
    val original: String,
)

fun ShowImageDto.toModel(): ShowImage = ShowImage(
    medium = this.medium,
    original = this.original
)

fun ShowImageDto.toEntity(): ShowImageEntity = ShowImageEntity(
    medium = this.medium,
    original = this.original
)

