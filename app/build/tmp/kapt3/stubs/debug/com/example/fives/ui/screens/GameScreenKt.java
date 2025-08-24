package com.example.fives.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001e\u0010\u0004\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a,\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a*\u0010\u000f\u001a\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007\u00a8\u0006\u0013"}, d2 = {"GameScreen", "", "uiState", "Lcom/example/fives/ui/viewmodel/GameUiState;", "onAddRound", "Lkotlin/Function1;", "", "", "", "onEndGame", "Lkotlin/Function0;", "ScoreInputField", "playerName", "value", "onValueChange", "Scoreboard", "players", "", "scores", "app_debug"})
public final class GameScreenKt {
    
    @androidx.compose.runtime.Composable
    public static final void GameScreen(@org.jetbrains.annotations.NotNull
    com.example.fives.ui.viewmodel.GameUiState uiState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.util.Map<java.lang.String, java.lang.Integer>, kotlin.Unit> onAddRound, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onEndGame) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void Scoreboard(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> players, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.Integer> scores) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ScoreInputField(@org.jetbrains.annotations.NotNull
    java.lang.String playerName, @org.jetbrains.annotations.NotNull
    java.lang.String value, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChange) {
    }
}