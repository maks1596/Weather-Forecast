## Application Requirements
### General Application Requirements
When developing an application, the following requirements must be met: 

- Use the Kotlin language 
- Use [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines) for asynchronous tasks and for working on different threads 
- Use [Android Jetpack](https://developer.android.com/jetpack) and [AndroidX](https://developer.android.com/jetpack/androidx) 
- Use MVVM architecture, implement it using Architecture Components (part of Android Jetpack) 
   - [Google Architecture Guide](https://developer.android.com/jetpack/guide) 
- Use the Repository pattern for working with data 
- Store data in a database, use [Room](https://developer.android.com/training/data-storage/room) to work with a database (part of Android Jetpack) 
- Store application settings in [Shared Preferences](https://developer.android.com/training/data-storage/shared-preferences) (or other suitable solution for storing data in the form of key-value) 
- Optionaly use DataStore instead (part of Android Jetpack) 
- Use [Retrofit](https://square.github.io/retrofit) and [Gson](https://github.com/google/gson) (a possible alternative to Moshi) libraries to work with the API 
- Use [Fragments](https://developer.android.com/guide/fragments) (from AndroidX) 
- Use [ConstraintLayout](https://developer.android.com/training/constraint-layout) 
- Use [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview) 
- Use [Navigation Component](https://developer.android.com/guide/navigation) for navigation (part of Android Jetpack) 
- Implement [Material Design](https://developer.android.com/guide/topics/ui/look-and-feel) 
   - [Material Components](https://github.com/material-components/material-components-android) library (optional) 
   - [Android Material Design](https://material.io/develop/android) portal 
   - Examples for inspiration: [Android Templates](https://www.uplabs.com/templates/android) 
- The application must also work offline 
   - [Google Connectivity Guide](https://developer.android.com/docs/quality-guidelines/build-for-billions/connectivity#network-arch) 
- Keep logs 
   - Popular library for logging [Timber](https://github.com/JakeWharton/timber) (optional) 
- Use [Work Manager](https://developer.android.com/topic/libraries/architecture/workmanager) to periodically refresh data 
- Implement Single Activity pattern (optional) 
   - [Single activity: Why, when, and how](https://www.youtube.com/watch?v=2k8x8V77CrU) 
- Implement animation of content of screens and transitions between screens (optional)
   - [Google Animation Guide](https://developer.android.com/training/animation) 
- Use library for DI (optional)
   - [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
   - [Dagger](https://developer.android.com/training/dependency-injection/dagger-basics)
   - [Koin](https://insert-koin.io/) 
- Write tests (unit and UI) (optional) 
   - [Guide for writing tests on Android](https://developer.android.com/training/testing) 
- Provide support for 2 languages (optional)
   - [Guide for supporting multiple languages on Android](https://developer.android.com/training/basics/supporting-devices/languages) 
   - [Guide for localization on Android](https://developer.android.com/guide/topics/resources/localization)
