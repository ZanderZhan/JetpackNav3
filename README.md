# JetpackNav3 Sample Application

This is a sample Android application demonstrating the usage of **Jetpack Navigation 3 (Nav3)** with Jetpack Compose.

## Features

- **Jetpack Navigation 3**: Uses the latest experimental navigation library from Google.
- **Type-Safe Navigation**: Leverages Kotlin Serialization for type-safe navigation keys (`Home`, `Profile`).
- **Jetpack Compose**: Built entirely using modern Compose UI.
- **Backstack Management**: Demonstrates using `rememberNavBackStack` for handling navigation state.

## Project Structure

- `MainActivity.kt`: Contains the entry point and navigation logic using `NavDisplay`.
- `NavKey`: Navigation destinations are defined as `@Serializable` data objects implementing `NavKey`.
- `EntryProvider`: Uses the `entryProvider` DSL to map navigation keys to Composable screens.

## Getting Started

1. Ensure you have Android Studio installed.
2. The project uses Kotlin 2.0.21 and Jetpack Compose.
3. It requires the `kotlin-serialization` plugin to be applied in `build.gradle.kts`.

## Dependencies

Key dependencies include:
- `androidx.navigation3:navigation3-ui`
- `androidx.navigation3:navigation3-runtime`
- `org.jetbrains.kotlinx:kotlinx-serialization-json`
