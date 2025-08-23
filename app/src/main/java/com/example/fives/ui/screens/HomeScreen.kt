package com.example.fives.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fives.R
import com.example.fives.data.Game
import com.example.fives.ui.viewmodel.GameState
import com.example.fives.ui.viewmodel.GameUiState
import com.example.fives.ui.viewmodel.GameViewModel

@Composable
fun HomeScreen(
    uiState: GameUiState,
    onNewGame: () -> Unit,
    onViewGame: (Game) -> Unit,
    onDeleteGame: (Game) -> Unit,
    getFormattedDate: (Game) -> String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        Button(
            onClick = onNewGame,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(
                text = stringResource(R.string.new_game),
                fontSize = 18.sp
            )
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Text(
            text = stringResource(R.string.game_history),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        if (uiState.games.isEmpty()) {
            Text(
                text = stringResource(R.string.no_games_yet),
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(uiState.games) { game ->
                    GameHistoryCard(
                        game = game,
                        onViewGame = onViewGame,
                        onDeleteGame = onDeleteGame,
                        getFormattedDate = getFormattedDate
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameHistoryCard(
    game: Game,
    onViewGame: (Game) -> Unit,
    onDeleteGame: (Game) -> Unit,
    getFormattedDate: (Game) -> String
) {
    Card(
        onClick = { onViewGame(game) },
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = getFormattedDate(game),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                text = "${game.playerNames.size} ${stringResource(R.string.players)}",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = game.playerNames.joinToString(", "),
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.weight(1f)
                )
                
                TextButton(
                    onClick = { onDeleteGame(game) }
                ) {
                    Text(
                        text = stringResource(R.string.delete_game),
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}
