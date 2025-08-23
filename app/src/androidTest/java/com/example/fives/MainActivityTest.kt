package com.example.fives

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fives.ui.screens.HomeScreen
import com.example.fives.ui.screens.NewGameScreen
import com.example.fives.ui.viewmodel.GameUiState
import com.example.fives.ui.viewmodel.GameState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testHomeScreenDisplay() {
        composeTestRule.onNodeWithText("5s").assertIsDisplayed()
        composeTestRule.onNodeWithText("New Game").assertIsDisplayed()
        composeTestRule.onNodeWithText("Game History").assertIsDisplayed()
    }

    @Test
    fun testNewGameButtonClick() {
        composeTestRule.onNodeWithText("New Game").performClick()
        composeTestRule.onNodeWithText("Add Player").assertIsDisplayed()
    }

    @Test
    fun testAddPlayerInNewGame() {
        composeTestRule.onNodeWithText("New Game").performClick()
        composeTestRule.onNodeWithText("Add Player").performClick()
        
        // Should have two player input fields now
        composeTestRule.onAllNodesWithText("Player Name").assertCountAtLeast(2)
    }

    @Test
    fun testStartGameWithValidPlayers() {
        composeTestRule.onNodeWithText("New Game").performClick()
        
        // Enter player names
        composeTestRule.onAllNodesWithText("Player Name")[0].performTextInput("Alice")
        composeTestRule.onAllNodesWithText("Player Name")[1].performTextInput("Bob")
        
        composeTestRule.onNodeWithText("Start Game").performClick()
        
        // Should navigate to game screen
        composeTestRule.onNodeWithText("Round 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Target: 240").assertIsDisplayed()
    }

    @Test
    fun testStartGameWithInvalidPlayers() {
        composeTestRule.onNodeWithText("New Game").performClick()
        
        // Try to start without entering player names
        composeTestRule.onNodeWithText("Start Game").performClick()
        
        // Should show error message
        composeTestRule.onNodeWithText("Please enter at least 2 player names").assertIsDisplayed()
    }

    @Test
    fun testGameScreenScoreInput() {
        // Navigate to game screen
        composeTestRule.onNodeWithText("New Game").performClick()
        composeTestRule.onAllNodesWithText("Player Name")[0].performTextInput("Alice")
        composeTestRule.onAllNodesWithText("Player Name")[1].performTextInput("Bob")
        composeTestRule.onNodeWithText("Start Game").performClick()
        
        // Enter scores
        composeTestRule.onAllNodesWithText("Alice")[1].performTextInput("10")
        composeTestRule.onAllNodesWithText("Bob")[1].performTextInput("15")
        
        composeTestRule.onNodeWithText("Next Round").performClick()
        
        // Should advance to round 2
        composeTestRule.onNodeWithText("Round 2").assertIsDisplayed()
    }

    @Test
    fun testEndGame() {
        // Navigate to game screen
        composeTestRule.onNodeWithText("New Game").performClick()
        composeTestRule.onAllNodesWithText("Player Name")[0].performTextInput("Alice")
        composeTestRule.onAllNodesWithText("Player Name")[1].performTextInput("Bob")
        composeTestRule.onNodeWithText("Start Game").performClick()
        
        composeTestRule.onNodeWithText("End Game").performClick()
        
        // Should show game summary
        composeTestRule.onNodeWithText("Game Summary").assertIsDisplayed()
        composeTestRule.onNodeWithText("Winner").assertIsDisplayed()
    }
}
