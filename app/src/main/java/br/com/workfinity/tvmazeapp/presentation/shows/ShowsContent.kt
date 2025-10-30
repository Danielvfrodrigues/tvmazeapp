package br.com.workfinity.tvmazeapp.presentation.shows

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ShowsContent(
    uiState: ShowsUiState,
    onNavigateUp: () -> Unit
) {
    Text("${uiState.shows}")
}