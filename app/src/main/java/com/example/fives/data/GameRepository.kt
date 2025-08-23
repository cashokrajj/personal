package com.example.fives.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class GameRepository(private val gameDao: GameDao) {
    
    fun getAllGames(): Flow<List<Game>> = gameDao.getAllGames()
    
    suspend fun getGameById(gameId: Long): Game? = gameDao.getGameById(gameId)
    
    suspend fun insertGame(game: Game): Long = gameDao.insertGame(game)
    
    suspend fun deleteGame(game: Game) {
        gameDao.deleteRoundsForGame(game.id)
        gameDao.deleteGame(game)
    }
    
    fun getRoundsForGame(gameId: Long): Flow<List<Round>> = gameDao.getRoundsForGame(gameId)
    
    suspend fun insertRound(round: Round) = gameDao.insertRound(round)
    
    suspend fun getGameWithRounds(gameId: Long): GameWithRounds? {
        val game = gameDao.getGameById(gameId) ?: return null
        val rounds = gameDao.getRoundsForGame(gameId).first()
        return GameWithRounds(game, rounds)
    }
}

data class GameWithRounds(
    val game: Game,
    val rounds: List<Round>
)
