package com.example.fives.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fives.R
import com.example.fives.ui.viewmodel.GameUiState

@Composable
fun GameScreen(
    uiState: GameUiState,
    onAddRound: (Map<String, Int>) -> Unit,
    onEndGame: () -> Unit
) {
    val currentGame = uiState.currentGame
    if (currentGame == null) return
    
    var roundScores by remember { mutableStateOf(currentGame.playerNames.associateWith { "" }) }
    var showError by remember { mutableStateOf(false) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.round) + " ${uiState.currentRound}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            
            Text(
                text = stringResource(R.string.target_score),
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Scoreboard
        Scoreboard(
            players = currentGame.playerNames,
            scores = uiState.currentScores
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Round score input
        Text(
            text = stringResource(R.string.enter_score),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(currentGame.playerNames) { player ->
                ScoreInputField(
                    playerName = player,
                    value = roundScores[player] ?: "",
                    onValueChange = { value ->
                        roundScores = roundScores.toMutableMap().apply {
                            this[player] = value
                        }
                    }
                )
            }
        }
        
        if (showError) {
            Text(
                text = "Please enter valid scores for all players",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        
        // Action buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = onEndGame,
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.end_game))
            }
            
            Button(
                onClick = {
                    val scores = roundScores.mapValues { it.value.toIntOrNull() }
                    if (scores.values.all { it != null }) {
                        onAddRound(scores.mapValues { it.value!! })
                        roundScores = currentGame.playerNames.associateWith { "" }
                        showError = false
                    } else {
                        showError = true
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.next_round))
            }
        }
    }
}

@Composable
fun Scoreboard(
    players: List<String>,
    scores: Map<String, Int>
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.total_score),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            players.forEach { player ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = player,
                        fontSize = 14.sp
                    )
                    Text(
                        text = (scores[player] ?: 0).toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Composable
fun ScoreInputField(
    playerName: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(playerName) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true
    )
}
