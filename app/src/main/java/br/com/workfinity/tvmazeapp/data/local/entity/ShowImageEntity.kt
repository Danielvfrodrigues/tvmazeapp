package br.com.workfinity.tvmazeapp.data.local.entity

import br.com.workfinity.tvmazeapp.domain.model.ShowImage

data class ShowImageEntity(
    val medium: String,
    val original: String,
)

fun ShowImageEntity.toModel() = ShowImage(
    medium = this.medium,
    original = this.original
)
