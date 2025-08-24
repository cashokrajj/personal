package com.example.fives.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0007H\u00c6\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\fH\u00c6\u0003JO\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\"\u001a\u00020\nH\u00d6\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/example/fives/ui/viewmodel/GameUiState;", "", "games", "", "Lcom/example/fives/data/Game;", "currentGame", "currentRound", "", "currentScores", "", "", "gameState", "Lcom/example/fives/ui/viewmodel/GameState;", "(Ljava/util/List;Lcom/example/fives/data/Game;ILjava/util/Map;Lcom/example/fives/ui/viewmodel/GameState;)V", "getCurrentGame", "()Lcom/example/fives/data/Game;", "getCurrentRound", "()I", "getCurrentScores", "()Ljava/util/Map;", "getGameState", "()Lcom/example/fives/ui/viewmodel/GameState;", "getGames", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class GameUiState {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.fives.data.Game> games = null;
    @org.jetbrains.annotations.Nullable
    private final com.example.fives.data.Game currentGame = null;
    private final int currentRound = 0;
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<java.lang.String, java.lang.Integer> currentScores = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.fives.ui.viewmodel.GameState gameState = null;
    
    public GameUiState(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.fives.data.Game> games, @org.jetbrains.annotations.Nullable
    com.example.fives.data.Game currentGame, int currentRound, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.Integer> currentScores, @org.jetbrains.annotations.NotNull
    com.example.fives.ui.viewmodel.GameState gameState) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.fives.data.Game> getGames() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.example.fives.data.Game getCurrentGame() {
        return null;
    }
    
    public final int getCurrentRound() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.Integer> getCurrentScores() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.fives.ui.viewmodel.GameState getGameState() {
        return null;
    }
    
    public GameUiState() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.fives.data.Game> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.example.fives.data.Game component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.Integer> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.fives.ui.viewmodel.GameState component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.fives.ui.viewmodel.GameUiState copy(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.fives.data.Game> games, @org.jetbrains.annotations.Nullable
    com.example.fives.data.Game currentGame, int currentRound, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.Integer> currentScores, @org.jetbrains.annotations.NotNull
    com.example.fives.ui.viewmodel.GameState gameState) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}