package com.example.fives.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GameDao_Impl implements GameDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Game> __insertionAdapterOfGame;

  private final Converters __converters = new Converters();

  private final EntityInsertionAdapter<Round> __insertionAdapterOfRound;

  private final EntityDeletionOrUpdateAdapter<Game> __deletionAdapterOfGame;

  private final SharedSQLiteStatement __preparedStmtOfDeleteRoundsForGame;

  public GameDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGame = new EntityInsertionAdapter<Game>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `games` (`id`,`date`,`playerNames`,`targetScore`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Game entity) {
        statement.bindLong(1, entity.getId());
        final String _tmp = __converters.dateToTimestamp(entity.getDate());
        if (_tmp == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, _tmp);
        }
        final String _tmp_1 = __converters.toStringList(entity.getPlayerNames());
        if (_tmp_1 == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp_1);
        }
        statement.bindLong(4, entity.getTargetScore());
      }
    };
    this.__insertionAdapterOfRound = new EntityInsertionAdapter<Round>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `rounds` (`id`,`gameId`,`roundNumber`,`scores`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Round entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getGameId());
        statement.bindLong(3, entity.getRoundNumber());
        final String _tmp = __converters.toStringMap(entity.getScores());
        if (_tmp == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp);
        }
      }
    };
    this.__deletionAdapterOfGame = new EntityDeletionOrUpdateAdapter<Game>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `games` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Game entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteRoundsForGame = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM rounds WHERE gameId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertGame(final Game game, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfGame.insertAndReturnId(game);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertRound(final Round round, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRound.insert(round);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteGame(final Game game, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfGame.handle(game);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteRoundsForGame(final long gameId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteRoundsForGame.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, gameId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteRoundsForGame.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Game>> getAllGames() {
    final String _sql = "SELECT * FROM games ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"games"}, new Callable<List<Game>>() {
      @Override
      @NonNull
      public List<Game> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfPlayerNames = CursorUtil.getColumnIndexOrThrow(_cursor, "playerNames");
          final int _cursorIndexOfTargetScore = CursorUtil.getColumnIndexOrThrow(_cursor, "targetScore");
          final List<Game> _result = new ArrayList<Game>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Game _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final LocalDateTime _tmpDate;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp);
            final List<String> _tmpPlayerNames;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPlayerNames)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfPlayerNames);
            }
            _tmpPlayerNames = __converters.fromStringList(_tmp_1);
            final int _tmpTargetScore;
            _tmpTargetScore = _cursor.getInt(_cursorIndexOfTargetScore);
            _item = new Game(_tmpId,_tmpDate,_tmpPlayerNames,_tmpTargetScore);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getGameById(final long gameId, final Continuation<? super Game> $completion) {
    final String _sql = "SELECT * FROM games WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, gameId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Game>() {
      @Override
      @Nullable
      public Game call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfPlayerNames = CursorUtil.getColumnIndexOrThrow(_cursor, "playerNames");
          final int _cursorIndexOfTargetScore = CursorUtil.getColumnIndexOrThrow(_cursor, "targetScore");
          final Game _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final LocalDateTime _tmpDate;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp);
            final List<String> _tmpPlayerNames;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPlayerNames)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfPlayerNames);
            }
            _tmpPlayerNames = __converters.fromStringList(_tmp_1);
            final int _tmpTargetScore;
            _tmpTargetScore = _cursor.getInt(_cursorIndexOfTargetScore);
            _result = new Game(_tmpId,_tmpDate,_tmpPlayerNames,_tmpTargetScore);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Round>> getRoundsForGame(final long gameId) {
    final String _sql = "SELECT * FROM rounds WHERE gameId = ? ORDER BY roundNumber";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, gameId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"rounds"}, new Callable<List<Round>>() {
      @Override
      @NonNull
      public List<Round> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfGameId = CursorUtil.getColumnIndexOrThrow(_cursor, "gameId");
          final int _cursorIndexOfRoundNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "roundNumber");
          final int _cursorIndexOfScores = CursorUtil.getColumnIndexOrThrow(_cursor, "scores");
          final List<Round> _result = new ArrayList<Round>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Round _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpGameId;
            _tmpGameId = _cursor.getLong(_cursorIndexOfGameId);
            final int _tmpRoundNumber;
            _tmpRoundNumber = _cursor.getInt(_cursorIndexOfRoundNumber);
            final Map<String, Integer> _tmpScores;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfScores)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfScores);
            }
            _tmpScores = __converters.fromStringMap(_tmp);
            _item = new Round(_tmpId,_tmpGameId,_tmpRoundNumber,_tmpScores);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
