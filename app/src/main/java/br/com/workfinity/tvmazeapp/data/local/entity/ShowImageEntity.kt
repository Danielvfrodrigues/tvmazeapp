package br.com.workfinity.tvmazeapp.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import br.com.workfinity.tvmazeapp.domain.model.ShowImage

@Entity(
    tableName = "show_images",
    foreignKeys = [
        ForeignKey(
            entity = ShowEntity::class,
            parentColumns = ["id"],
            childColumns = ["showId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ShowImageEntity(
    @PrimaryKey val showId: Int,
    val medium: String,
    val original: String,
)

fun ShowImageEntity.toModel() = ShowImage(
    medium = this.medium,
    original = this.original
)
