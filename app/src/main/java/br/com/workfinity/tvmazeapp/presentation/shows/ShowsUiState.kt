package br.com.workfinity.tvmazeapp.presentation.shows

import br.com.workfinity.tvmazeapp.domain.model.Show

data class ShowsUiState(
    val isLoading: Boolean = false,
    val shows: List<Show> = emptyList(),
    val error: String = ""
)