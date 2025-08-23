package com.example.fives

import com.example.fives.data.Game
import com.example.fives.data.GameRepository
import com.example.fives.ui.viewmodel.GameState
import com.example.fives.ui.viewmodel.GameUiState
import com.example.fives.ui.viewmodel.GameViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import java.time.LocalDateTime

@OptIn(ExperimentalCoroutinesApi::class)
class GameViewModelTest {
    
    @Mock
    private lateinit var repository: GameRepository
    
    private lateinit var viewModel: GameViewModel
    private val testDispatcher = StandardTestDispatcher()
    
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.openMocks(this)
        `when`(repository.getAllGames()).thenReturn(MutableStateFlow(emptyList()))
        viewModel = GameViewModel(repository)
    }
    
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
    
    @Test
    fun `createNewGame should create game with correct players`() = runTest {
        // Given
        val playerNames = listOf("Alice", "Bob", "Charlie")
        val gameId = 1L
        `when`(repository.insertGame(any())).thenReturn(gameId)
        
        // When
        viewModel.createNewGame(playerNames)
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Then
        verify(repository).insertGame(any())
        assertEquals(GameState.PLAYING, viewModel.uiState.value.gameState)
        assertEquals(playerNames, viewModel.uiState.value.currentGame?.playerNames)
        assertEquals(1, viewModel.uiState.value.currentRound)
        assertEquals(playerNames.associateWith { 0 }, viewModel.uiState.value.currentScores)
    }
    
    @Test
    fun `addRound should update scores correctly`() = runTest {
        // Given
        val playerNames = listOf("Alice", "Bob")
        val gameId = 1L
        `when`(repository.insertGame(any())).thenReturn(gameId)
        `when`(repository.insertRound(any())).thenReturn(Unit)
        
        viewModel.createNewGame(playerNames)
        testDispatcher.scheduler.advanceUntilIdle()
        
        val roundScores = mapOf("Alice" to 10, "Bob" to 15)
        
        // When
        viewModel.addRound(roundScores)
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Then
        verify(repository).insertRound(any())
        assertEquals(2, viewModel.uiState.value.currentRound)
        assertEquals(mapOf("Alice" to 10, "Bob" to 15), viewModel.uiState.value.currentScores)
    }
    
    @Test
    fun `getWinner should return player with lowest score`() {
        // Given
        val scores = mapOf("Alice" to 50, "Bob" to 30, "Charlie" to 45)
        viewModel.uiState.value = viewModel.uiState.value.copy(currentScores = scores)
        
        // When
        val winner = viewModel.getWinner()
        
        // Then
        assertEquals("Bob", winner)
    }
    
    @Test
    fun `endGame should change state to finished`() {
        // Given
        viewModel.uiState.value = viewModel.uiState.value.copy(gameState = GameState.PLAYING)
        
        // When
        viewModel.endGame()
        
        // Then
        assertEquals(GameState.FINISHED, viewModel.uiState.value.gameState)
    }
    
    @Test
    fun `resetGame should clear current game state`() {
        // Given
        viewModel.uiState.value = viewModel.uiState.value.copy(
            gameState = GameState.PLAYING,
            currentGame = Game(playerNames = listOf("Alice", "Bob")),
            currentRound = 5,
            currentScores = mapOf("Alice" to 100, "Bob" to 150)
        )
        
        // When
        viewModel.resetGame()
        
        // Then
        assertEquals(GameState.HOME, viewModel.uiState.value.gameState)
        assertNull(viewModel.uiState.value.currentGame)
        assertEquals(1, viewModel.uiState.value.currentRound)
        assertTrue(viewModel.uiState.value.currentScores.isEmpty())
    }
    
    @Test
    fun `getFormattedDate should format date correctly`() {
        // Given
        val date = LocalDateTime.of(2023, 12, 25, 14, 30)
        
        // When
        val formattedDate = viewModel.getFormattedDate(date)
        
        // Then
        assertEquals("Dec 25, 2023 14:30", formattedDate)
    }
}
