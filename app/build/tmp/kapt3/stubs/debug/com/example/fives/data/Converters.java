package com.example.fives.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0007J\u001e\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0007J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0007J\u0016\u0010\u0013\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0007J\u001c\u0010\u0015\u001a\u00020\t2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u0010H\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/fives/data/Converters;", "", "()V", "formatter", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "dateToTimestamp", "", "date", "Ljava/time/LocalDateTime;", "fromStringList", "", "value", "fromStringMap", "", "", "fromTimestamp", "toStringList", "list", "toStringMap", "map", "app_debug"})
public final class Converters {
    @org.jetbrains.annotations.NotNull
    private final com.google.gson.Gson gson = null;
    private final java.time.format.DateTimeFormatter formatter = null;
    
    public Converters() {
        super();
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.Nullable
    public final java.time.LocalDateTime fromTimestamp(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.Nullable
    public final java.lang.String dateToTimestamp(@org.jetbrains.annotations.Nullable
    java.time.LocalDateTime date) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> fromStringList(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.lang.String toStringList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> list) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.Integer> fromStringMap(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter
    @org.jetbrains.annotations.NotNull
    public final java.lang.String toStringMap(@org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.Integer> map) {
        return null;
    }
}