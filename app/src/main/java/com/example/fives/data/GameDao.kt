package com.example.fives.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {
    @Query("SELECT * FROM games ORDER BY date DESC")
    fun getAllGames(): Flow<List<Game>>

    @Query("SELECT * FROM games WHERE id = :gameId")
    suspend fun getGameById(gameId: Long): Game?

    @Insert
    suspend fun insertGame(game: Game): Long

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("SELECT * FROM rounds WHERE gameId = :gameId ORDER BY roundNumber")
    fun getRoundsForGame(gameId: Long): Flow<List<Round>>

    @Insert
    suspend fun insertRound(round: Round)

    @Query("DELETE FROM rounds WHERE gameId = :gameId")
    suspend fun deleteRoundsForGame(gameId: Long)
}
