# 5s - Android Game Score Tracker

A simple and elegant Android app for tracking scores in card games, built with Kotlin and Jetpack Compose.

## Features

- **Create New Games**: Add any number of players with custom names
- **Round-based Scoring**: Enter scores for each round manually
- **Automatic Score Accumulation**: Scores are automatically totaled across rounds
- **Real-time Scoreboard**: View current standings at any time during the game
- **Game Summary**: See final results with the winner highlighted (lowest score wins)
- **Game History**: View and manage past games stored locally
- **Target Score Reference**: Shows target score of 240 as a reference point
- **Clean UI**: Minimal and intuitive interface using Material Design 3

## Technical Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM with Clean Architecture principles
- **Database**: Room with SQLite
- **Navigation**: Jetpack Navigation Compose
- **State Management**: StateFlow and ViewModel
- **Testing**: JUnit for unit tests, Compose UI tests for integration tests

## Project Structure

```
app/src/main/java/com/example/fives/
├── data/                    # Data layer
│   ├── Game.kt             # Game entity
│   ├── Round.kt            # Round entity
│   ├── GameDao.kt          # Data Access Object
│   ├── GameDatabase.kt     # Room database
│   ├── GameRepository.kt   # Repository pattern
│   └── Converters.kt       # Type converters
├── ui/
│   ├── screens/            # UI screens
│   │   ├── HomeScreen.kt
│   │   ├── NewGameScreen.kt
│   │   ├── GameScreen.kt
│   │   └── GameSummaryScreen.kt
│   ├── theme/              # UI theme
│   │   ├── Color.kt
│   │   ├── Theme.kt
│   │   └── Type.kt
│   └── viewmodel/          # ViewModels
│       └── GameViewModel.kt
└── MainActivity.kt         # Main activity
```

## Setup Instructions

### Prerequisites

- Android Studio Arctic Fox or later
- Android SDK 24 or higher
- Java 8 or higher

### Building the Project

1. Clone or download the project
2. Open the project in Android Studio
3. Sync the project with Gradle files
4. Build the project (Build > Make Project)

### Running the App

1. Connect an Android device or start an emulator
2. Click the "Run" button in Android Studio
3. Select your device/emulator and install the app

### Building APK

To generate an APK file:

1. Go to Build > Build Bundle(s) / APK(s) > Build APK(s)
2. Wait for the build to complete
3. Click "locate" in the notification to find the APK file
4. The APK will be in `app/build/outputs/apk/debug/app-debug.apk`

## Usage

### Starting a New Game

1. Open the app
2. Tap "New Game"
3. Enter player names (minimum 2 players)
4. Tap "Start Game"

### Playing a Game

1. View the current scoreboard showing total scores
2. Enter scores for each player for the current round
3. Tap "Next Round" to continue or "End Game" to finish
4. The target score of 240 is shown as a reference

### Game Summary

- View final scores for all players
- The winner (lowest score) is highlighted
- Tap "Back to Home" to return to the main screen

### Game History

- View all past games on the home screen
- Tap on a game to view details
- Tap "Delete Game" to remove games from history

## Testing

The project includes comprehensive tests:

### Unit Tests
- `GameViewModelTest.kt`: Tests for game logic, score management, and winner calculation

### Instrumented Tests
- `MainActivityTest.kt`: UI tests for navigation and user interactions

### Running Tests

```bash
# Run unit tests
./gradlew test

# Run instrumented tests
./gradlew connectedAndroidTest
```

## Architecture

The app follows Clean Architecture principles:

- **Presentation Layer**: UI components and ViewModels
- **Domain Layer**: Business logic and use cases
- **Data Layer**: Repository, DAO, and database entities

### Key Design Patterns

- **MVVM**: Model-View-ViewModel for UI state management
- **Repository Pattern**: Abstraction layer for data operations
- **Observer Pattern**: StateFlow for reactive UI updates
- **Dependency Injection**: Manual dependency injection for simplicity

## Database Schema

### Games Table
- `id`: Primary key
- `date`: Game creation timestamp
- `playerNames`: JSON array of player names
- `targetScore`: Target score (default 240)

### Rounds Table
- `id`: Primary key
- `gameId`: Foreign key to games table
- `roundNumber`: Round number
- `scores`: JSON object mapping player names to scores

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## License

This project is open source and available under the [MIT License](LICENSE).

## Support

For issues or questions, please create an issue in the repository.
