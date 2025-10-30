package br.com.workfinity.tvmazeapp.presentation.shows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.workfinity.tvmazeapp.domain.usecase.GetAllShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ShowsViewModel(
    private val getAllShowsUseCase: GetAllShowsUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ShowsUiState())
    val uiState = _uiState

    fun getAllShows() {
        viewModelScope.launch {
            getAllShowsUseCase.invoke().fold(
                onSuccess = { shows ->
                    _uiState.update { it.copy(shows = shows) }
                },
                onFailure = { throwable ->
                    _uiState.update { it.copy(error = throwable.message ?: "Unknown error") }
                }
            )
        }
    }
}