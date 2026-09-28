# FitGo — Fitness Social App (Android)

Maintaining a healthy lifestyle is challenging due to issues like lack of motivation, isolation, and difficulty tracking progress. FitGO, a fitness social app, tackles these problems through technology, community, and gamification.

**⬇ [Download APK](app/release/fitgo_ver1.apk)** (Android 8.0+)

![111](https://github.com/user-attachments/assets/51d91041-bce1-465c-a046-c481cd5cb0ce) ![2222](https://github.com/user-attachments/assets/fc854af1-6b3f-46b9-b07d-2ed007426306) ![3333](https://github.com/user-attachments/assets/77897c32-491b-4685-b210-6d74fca11519)
![4444](https://github.com/user-attachments/assets/5c23eb32-7017-4197-ab77-4178426fd7f7) ![5555](https://github.com/user-attachments/assets/a2635071-e2b2-43a0-bc31-ec95566e23a5) ![6666](https://github.com/user-attachments/assets/0cac9532-4014-491f-950c-8278d72eeaa7)
![777](https://github.com/user-attachments/assets/374ca4c3-0225-4b97-93f2-ed0889624a58) ![888](https://github.com/user-attachments/assets/831fcb93-f305-4fc9-aaaf-0892a09ea5e0) ![999](https://github.com/user-attachments/assets/61543831-b841-43c5-a0b4-b04509d3da09)
![1000](https://github.com/user-attachments/assets/b1b7d60c-47ff-4eb1-9427-1aa13c280a73) ![101](https://github.com/user-attachments/assets/a0709e04-3b74-4315-900c-ab5df2185832)

## Features
- **Onboarding & login** with splash screen
- **Home feed** of workout posts; **create your own posts**
- **Explore**: fitness challenges and trainers
- **Trainers** list and profiles
- **Chats** with conversation screens
- **Profile** with achievements, workouts, my posts and followers
- **Notifications** and **settings** with profile editing
- Bottom navigation with animated screen transitions

## Tech stack
- **Kotlin**, **Jetpack Compose**, **Material 3**
- **Clean Architecture** — `data` / `domain` / `presentation` layers, repository interfaces with implementations
- **MVVM** with screen `State` / `Event` classes and `ViewModel`s
- **Hilt** for dependency injection
- **Room** database (with type converters) and **DataStore** preferences
- **Navigation Compose** with type-safe `@Serializable` destinations
- **Coil** for image loading, **Kotlin Coroutines & Flow**, **kotlinx.serialization**

## Project structure
```
app/src/main/java/com/app/fitgo/
├── data/          Room database, DAOs, repository implementations, sample data
├── data_store/    DataStore preferences
├── di/            Hilt modules
├── domain/        models and repository interfaces
├── navigation/    navigation graph, destinations, bottom navigation
├── presentation/  screens + ViewModels (home, explore, chats, profile, trainer, …)
└── ui/theme/      colors, typography, theme
```

## Build
Open in Android Studio (JDK 11+, Android SDK 35) and run, or `./gradlew assembleDebug`.
The app currently runs on local sample data stored in Room — no backend required.
