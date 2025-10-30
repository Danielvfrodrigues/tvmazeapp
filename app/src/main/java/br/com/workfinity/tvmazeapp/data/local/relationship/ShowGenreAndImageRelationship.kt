package br.com.workfinity.tvmazeapp.data.local.relationship

import androidx.room.Embedded
import androidx.room.Relation
import br.com.workfinity.tvmazeapp.data.local.entity.ShowEntity
import br.com.workfinity.tvmazeapp.data.local.entity.ShowGenreEntity
import br.com.workfinity.tvmazeapp.data.local.entity.ShowImageEntity

data class ShowWithGenresAndImage(
    @Embedded val showEntity: ShowEntity,

    @Relation(parentColumn = "id", entityColumn = "showId")
    val genres: List<ShowGenreEntity>,
    @Relation(parentColumn = "id", entityColumn = "showId")
    val image: ShowImageEntity
)