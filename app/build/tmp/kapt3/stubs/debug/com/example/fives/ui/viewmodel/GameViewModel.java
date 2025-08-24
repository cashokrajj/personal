package com.example.fives.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013J\u0014\u0010\u0016\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u0004\u0018\u00010\u0014J\u0006\u0010!\u001a\u00020\u0011J\u0006\u0010\"\u001a\u00020\u0011R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\u00a8\u0006#"}, d2 = {"Lcom/example/fives/ui/viewmodel/GameViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/fives/data/GameRepository;", "(Lcom/example/fives/data/GameRepository;)V", "_currentGameId", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_uiState", "Lcom/example/fives/ui/viewmodel/GameUiState;", "currentGameId", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentGameId", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "getUiState", "addRound", "", "scores", "", "", "", "createNewGame", "playerNames", "", "deleteGame", "game", "Lcom/example/fives/data/Game;", "endGame", "getFormattedDate", "date", "Ljava/time/LocalDateTime;", "getWinner", "loadGames", "resetGame", "app_debug"})
public final class GameViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.fives.data.GameRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.fives.ui.viewmodel.GameUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.fives.ui.viewmodel.GameUiState> uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Long> _currentGameId = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Long> currentGameId = null;
    
    public GameViewModel(@org.jetbrains.annotations.NotNull
    com.example.fives.data.GameRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.fives.ui.viewmodel.GameUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> getCurrentGameId() {
        return null;
    }
    
    public final void loadGames() {
    }
    
    public final void createNewGame(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> playerNames) {
    }
    
    public final void addRound(@org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.Integer> scores) {
    }
    
    public final void endGame() {
    }
    
    public final void resetGame() {
    }
    
    public final void deleteGame(@org.jetbrains.annotations.NotNull
    com.example.fives.data.Game game) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getWinner() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFormattedDate(@org.jetbrains.annotations.NotNull
    java.time.LocalDateTime date) {
        return null;
    }
}