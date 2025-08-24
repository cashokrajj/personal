package com.example.fives.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0005H\u0007\u001aZ\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0005H\u0007\u00a8\u0006\u000e"}, d2 = {"GameHistoryCard", "", "game", "Lcom/example/fives/data/Game;", "onViewGame", "Lkotlin/Function1;", "onDeleteGame", "getFormattedDate", "", "HomeScreen", "uiState", "Lcom/example/fives/ui/viewmodel/GameUiState;", "onNewGame", "Lkotlin/Function0;", "app_debug"})
public final class HomeScreenKt {
    
    @androidx.compose.runtime.Composable
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull
    com.example.fives.ui.viewmodel.GameUiState uiState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNewGame, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.fives.data.Game, kotlin.Unit> onViewGame, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.fives.data.Game, kotlin.Unit> onDeleteGame, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.fives.data.Game, java.lang.String> getFormattedDate) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void GameHistoryCard(@org.jetbrains.annotations.NotNull
    com.example.fives.data.Game game, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.fives.data.Game, kotlin.Unit> onViewGame, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.fives.data.Game, kotlin.Unit> onDeleteGame, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.fives.data.Game, java.lang.String> getFormattedDate) {
    }
}