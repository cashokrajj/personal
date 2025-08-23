package com.example.fives.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fives.data.Game
import com.example.fives.data.GameRepository
import com.example.fives.data.Round
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GameViewModel(private val repository: GameRepository) : ViewModel() {
    
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    
    private val _currentGameId = MutableStateFlow<Long?>(null)
    val currentGameId: StateFlow<Long?> = _currentGameId.asStateFlow()
    
    init {
        loadGames()
    }
    
    fun loadGames() {
        viewModelScope.launch {
            repository.getAllGames().collect { games ->
                _uiState.value = _uiState.value.copy(games = games)
            }
        }
    }
    
    fun createNewGame(playerNames: List<String>) {
        if (playerNames.isEmpty()) return
        
        viewModelScope.launch {
            val game = Game(
                playerNames = playerNames,
                targetScore = 240
            )
            val gameId = repository.insertGame(game)
            _currentGameId.value = gameId
            _uiState.value = _uiState.value.copy(
                currentGame = game.copy(id = gameId),
                currentRound = 1,
                currentScores = playerNames.associateWith { 0 },
                gameState = GameState.PLAYING
            )
        }
    }
    
    fun addRound(scores: Map<String, Int>) {
        val gameId = _currentGameId.value ?: return
        val currentRound = _uiState.value.currentRound
        
        viewModelScope.launch {
            val round = Round(
                gameId = gameId,
                roundNumber = currentRound,
                scores = scores
            )
            repository.insertRound(round)
            
            // Update current scores
            val currentScores = _uiState.value.currentScores.toMutableMap()
            scores.forEach { (player, score) ->
                currentScores[player] = (currentScores[player] ?: 0) + score
            }
            
            _uiState.value = _uiState.value.copy(
                currentRound = currentRound + 1,
                currentScores = currentScores
            )
        }
    }
    
    fun endGame() {
        _uiState.value = _uiState.value.copy(gameState = GameState.FINISHED)
    }
    
    fun resetGame() {
        _currentGameId.value = null
        _uiState.value = GameUiState()
        loadGames()
    }
    
    fun deleteGame(game: Game) {
        viewModelScope.launch {
            repository.deleteGame(game)
        }
    }
    
    fun getWinner(): String? {
        val scores = _uiState.value.currentScores
        if (scores.isEmpty()) return null
        
        return scores.minByOrNull { it.value }?.key
    }
    
    fun getFormattedDate(date: LocalDateTime): String {
        val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm")
        return date.format(formatter)
    }
}

data class GameUiState(
    val games: List<Game> = emptyList(),
    val currentGame: Game? = null,
    val currentRound: Int = 1,
    val currentScores: Map<String, Int> = emptyMap(),
    val gameState: GameState = GameState.HOME
)

enum class GameState {
    HOME,
    PLAYING,
    FINISHED
}
