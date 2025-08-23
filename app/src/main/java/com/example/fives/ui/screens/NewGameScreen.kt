package com.example.fives.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
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

@Composable
fun NewGameScreen(
    onStartGame: (List<String>) -> Unit,
    onBack: () -> Unit
) {
    var players by remember { mutableStateOf(listOf("")) }
    var showError by remember { mutableStateOf(false) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.new_game),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(players) { index, player ->
                PlayerInputField(
                    value = player,
                    onValueChange = { newValue ->
                        players = players.toMutableList().apply {
                            this[index] = newValue
                        }
                    },
                    onDelete = {
                        if (players.size > 1) {
                            players = players.toMutableList().apply {
                                removeAt(index)
                            }
                        }
                    },
                    canDelete = players.size > 1
                )
            }
            
            item {
                Button(
                    onClick = {
                        players = players + ""
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(stringResource(R.string.add_player))
                }
            }
        }
        
        if (showError) {
            Text(
                text = "Please enter at least 2 player names",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = onBack,
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.cancel))
            }
            
            Button(
                onClick = {
                    val validPlayers = players.filter { it.isNotBlank() }
                    if (validPlayers.size >= 2) {
                        onStartGame(validPlayers)
                    } else {
                        showError = true
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.start_game))
            }
        }
    }
}

@Composable
fun PlayerInputField(
    value: String,
    onValueChange: (String) -> Unit,
    onDelete: () -> Unit,
    canDelete: Boolean
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(stringResource(R.string.player_name)) },
            modifier = Modifier.weight(1f),
            singleLine = true
        )
        
        if (canDelete) {
            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete player",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}
