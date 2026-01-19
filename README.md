# JetpackNav3 Sample Application

This is a sample Android application demonstrating the usage of **Jetpack Navigation 3 (Nav3)** with Jetpack Compose.

## Features

- **Jetpack Navigation 3**: Uses the latest experimental navigation library from Google.
- **Type-Safe Navigation**: Leverages Kotlin Serialization for type-safe navigation keys (`Home`, `Profile`, `FlowerDetail`).
- **Jetpack Compose**: Built entirely using modern Compose UI.
- **Backstack Management**: Demonstrates using `SnapshotStateList` and `mutableStateListOf` for flexible, observable navigation state across multiple tabs.
- **Adaptive Layouts**: Implements a custom `SceneStrategy` for List-Detail views on large screens.

## Project Structure

- `MainActivity.kt`: Contains the entry point and navigation logic using `NavDisplay`.
- `AppNavBackStack.kt`: Manages multiple tab-specific backstacks using observable state.
- `NavKey`: Navigation destinations are defined as `@Serializable` data objects.
- `EntryProvider`: Uses the `entryProvider` DSL to map navigation keys to Composable screens.
- `SceneStrategy`: Custom strategy (`ListDetailSceneStrategy`) to handle adaptive multi-pane layouts.

## Implementation Details

### Architectural Decorators
The project utilizes `rememberSaveableStateHolderNavEntryDecorator` and `rememberViewModelStoreNavEntryDecorator` to ensure that screen state is saved and ViewModels are properly scoped to their respective navigation entries.

### Adaptive Scenes
By leveraging the `SceneStrategy` API, the app can display two active destinations simultaneously (e.g., a list and a detail view) when sufficient screen width is available, while automatically reverting to a single-pane flow on smaller devices.

## TODO & Future Enhancements

- [ ] **CompositionLocal for Backstack**: Implement a custom `NavEntryDecorator` to provide the backstack via `CompositionLocal`, eliminating prop-drilling for navigation actions in deep hierarchies.
- [ ] **Synthetic Backstacks for Deep Linking**: Develop a utility to parse incoming URLs/Intents and generate logical backstack sequences (e.g., `[Home, Profile]` instead of just `[Profile]`) to ensure intuitive back navigation.
- [ ] **Metadata-Driven Transitions**: Utilize the Metadata DSL (anticipated in version 1.1) to define type-safe, declarative animations per `NavKey` type.
- [ ] **Kotlin Multiplatform (KMP) Readiness**: Move core navigation logic and `NavKey` definitions to a common KMP module to enable shared navigation state across Android, iOS, and Desktop.

## Getting Started

1. Ensure you have Android Studio installed.
2. The project uses Kotlin 2.1.0 and Jetpack Compose.
3. It requires the `kotlin-serialization` plugin to be applied in `build.gradle.kts`.

## Dependencies

Key dependencies include:
- `androidx.navigation3:navigation3-ui`
- `androidx.navigation3:navigation3-runtime`
- `androidx.lifecycle:lifecycle-viewmodel-navigation3`
- `androidx.compose.material3.adaptive:adaptive`
- `org.jetbrains.kotlinx:kotlinx-serialization-json`
