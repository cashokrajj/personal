package com.example.fives.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\u001b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0019\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/example/fives/data/GameRepository;", "", "gameDao", "Lcom/example/fives/data/GameDao;", "(Lcom/example/fives/data/GameDao;)V", "deleteGame", "", "game", "Lcom/example/fives/data/Game;", "(Lcom/example/fives/data/Game;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllGames", "Lkotlinx/coroutines/flow/Flow;", "", "getGameById", "gameId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGameWithRounds", "Lcom/example/fives/data/GameWithRounds;", "getRoundsForGame", "Lcom/example/fives/data/Round;", "insertGame", "insertRound", "round", "(Lcom/example/fives/data/Round;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GameRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.fives.data.GameDao gameDao = null;
    
    public GameRepository(@org.jetbrains.annotations.NotNull
    com.example.fives.data.GameDao gameDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.fives.data.Game>> getAllGames() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getGameById(long gameId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.fives.data.Game> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertGame(@org.jetbrains.annotations.NotNull
    com.example.fives.data.Game game, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteGame(@org.jetbrains.annotations.NotNull
    com.example.fives.data.Game game, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.fives.data.Round>> getRoundsForGame(long gameId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertRound(@org.jetbrains.annotations.NotNull
    com.example.fives.data.Round round, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getGameWithRounds(long gameId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.fives.data.GameWithRounds> $completion) {
        return null;
    }
}