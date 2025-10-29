package br.com.workfinity.tvmazeapp.domain.model

data class Show(
    val id: Int,
    val url: String,
    val name: String,
    val type: String,
    val language: String,
    val genres: List<String>,
    val status: String,
    val image: ShowImage,
    val summary: String,
)
