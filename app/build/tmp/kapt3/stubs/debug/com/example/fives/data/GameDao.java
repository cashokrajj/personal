package com.example.fives.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\f2\u0006\u0010\b\u001a\u00020\tH\'J\u0019\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/example/fives/data/GameDao;", "", "deleteGame", "", "game", "Lcom/example/fives/data/Game;", "(Lcom/example/fives/data/Game;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRoundsForGame", "gameId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllGames", "Lkotlinx/coroutines/flow/Flow;", "", "getGameById", "getRoundsForGame", "Lcom/example/fives/data/Round;", "insertGame", "insertRound", "round", "(Lcom/example/fives/data/Round;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface GameDao {
    
    @androidx.room.Query(value = "SELECT * FROM games ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.fives.data.Game>> getAllGames();
    
    @androidx.room.Query(value = "SELECT * FROM games WHERE id = :gameId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getGameById(long gameId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.fives.data.Game> $completion);
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertGame(@org.jetbrains.annotations.NotNull
    com.example.fives.data.Game game, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteGame(@org.jetbrains.annotations.NotNull
    com.example.fives.data.Game game, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM rounds WHERE gameId = :gameId ORDER BY roundNumber")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.fives.data.Round>> getRoundsForGame(long gameId);
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertRound(@org.jetbrains.annotations.NotNull
    com.example.fives.data.Round round, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM rounds WHERE gameId = :gameId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteRoundsForGame(long gameId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}