package com.example.fives

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fives.data.GameDatabase
import com.example.fives.data.GameRepository
import com.example.fives.ui.screens.*
import com.example.fives.ui.theme.FivesTheme
import com.example.fives.ui.viewmodel.GameState
import com.example.fives.ui.viewmodel.GameUiState
import com.example.fives.ui.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val database = GameDatabase.getDatabase(this)
        val repository = GameRepository(database.gameDao())
        
        setContent {
            FivesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FivesApp(repository)
                }
            }
        }
    }
}

@Composable
fun FivesApp(repository: GameRepository) {
    val navController = rememberNavController()
    val viewModel: GameViewModel = viewModel { GameViewModel(repository) }
    val uiState by viewModel.uiState.collectAsState()
    
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                uiState = uiState,
                onNewGame = { navController.navigate("new_game") },
                onViewGame = { game ->
                    // For now, we'll just show the game summary
                    // In a full implementation, you might want to load the game data
                },
                onDeleteGame = { game -> viewModel.deleteGame(game) },
                getFormattedDate = { game -> viewModel.getFormattedDate(game.date) }
            )
        }
        
        composable("new_game") {
            NewGameScreen(
                onStartGame = { players ->
                    viewModel.createNewGame(players)
                    navController.navigate("game") {
                        popUpTo("home") { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }
        
        composable("game") {
            when (uiState.gameState) {
                GameState.PLAYING -> {
                    GameScreen(
                        uiState = uiState,
                        onAddRound = { scores -> viewModel.addRound(scores) },
                        onEndGame = { viewModel.endGame() }
                    )
                }
                GameState.FINISHED -> {
                    GameSummaryScreen(
                        uiState = uiState,
                        onBackToHome = {
                            viewModel.resetGame()
                            navController.navigate("home") {
                                popUpTo("home") { inclusive = true }
                            }
                        }
                    )
                }
                else -> {
                    // This shouldn't happen, but just in case
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            }
        }
    }
}
