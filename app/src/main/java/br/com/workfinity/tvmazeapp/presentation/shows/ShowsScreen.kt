package br.com.workfinity.tvmazeapp.presentation.shows

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@Composable
fun ShowsScreen(
    navController: NavController,
    viewModel: ShowsViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ShowsContent(
        uiState = uiState,
        onNavigateUp = { navController.popBackStack() }
    )
}