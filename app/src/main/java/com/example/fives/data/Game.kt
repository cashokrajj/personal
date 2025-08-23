package com.example.fives.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "games")
data class Game(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: LocalDateTime = LocalDateTime.now(),
    val playerNames: List<String>,
    val targetScore: Int = 240
)
