## Application Description
An application for receiving and displaying weather forecast using a third-party API. 

#### Required features 
- Search by cities (via API) 
- Add and remove cities 
- Get a weather forecast for a particular city 
   - For a day 
   - For several days (e.g. a week, depending on API capabilities) 
- Display a list of cities with a brief information about the weather 
- Display a detailed forecast for a particular city (by API capabilities) 
   - For a day 
   - For a few days 
- Select the current city 
- Display a notification with the current weather (briefly) for the current city 
   - Periodic update of weather data 

#### List of screens: 

- Screen with a list of cities with brief information about the weather 
   - With the ability to remove cities 
   - With the ability to switch to the search screen and add cities 
   - With the transition to a detailed weather forecast 
- Screen for searching and adding cities 
- Detailed weather forecast screen 
   - For today 
   - For tomorrow 
   - For several days (for example, a week) 

> To get weather data, you can use the OpenWeather API (or other similar open services)

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
   - Optionally use [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) instead (part of Android Jetpack) 
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

### Detailed Application Requirements
#### List of cities 
- Use [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview) to display a list or a grid 
- The cell should contain the following information: 
   - city name,
   - weather icon, 
   - day and night temperature 
   - Weather icons can be displayed using Drawable pre-loaded into resources and associated with the type of weather   
   Icons can be generated in [Image Asset Studio](https://developer.android.com/studio/write/image-asset-studio) 
   - (optional) Icons can also be displayed using the URL of the images received from the API   
   You can use a library to load images i.e. [Glide](https://github.com/bumptech/glide) 
- Use [SwipeRefreshLayout](https://developer.android.com/training/swipe/add-swipe-interface) to update the list 
- Remove cities should be done by swiping to the side, for example using [ItemTouchHelper](https://developer.android.com/reference/androidx/recyclerview/widget/ItemTouchHelper) 
   - [Tutorial on Medium](https://medium.com/@ipaulpro/drag-and-swipe-with-recyclerview-b9456d2b1aaf) 
- You go to the screen for adding cities by clicking on the [FloatingActionButton](https://developer.android.com/guide/topics/ui/floating-action-button) 
- By clicking on the city, you go to the detailed weather forecast screen 
- Use the [Navigation Component](https://developer.android.com/guide/navigation) to navigate between screens 
- Data for UI must be loaded from the database, data in the database must be updated using the API 
- (optional) Use DiffUtil with RecyclerView
   - [Tutorial on MindOrks](https://blog.mindorks.com/the-powerful-tool-diff-util-in-recyclerview-android-tutorial) 
- (optional) Change the order of cities using Drag-and-drop, keep the order of cities in the database. The order can determine the current city, for example, the first city in the list can be the current one. 
   - [Tutorial on Medium](https://blog.mindorks.com/the-powerful-tool-diff-util-in-recyclerview-android-tutorial) 

#### Searching and adding cities 
- Use [SearchView](https://developer.android.com/reference/android/widget/SearchView) with [OnQueryTextListener](https://developer.android.com/reference/android/widget/SearchView.OnQueryTextListener) in [Toolbar](https://developer.android.com/training/appbar) to enter search query 
- Use [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview) to display search results 
- The cell must contain the name of the city and country 
- Use a search progress bar e.g. [ProgressBar](https://developer.android.com/reference/android/widget/ProgressBar) 
- Search must be performed using API 
- The search should be performed after confirming the input 
   - (optional) You can implement a search by changing the search string on the go. It is worth adding a delay before starting the search after the next user input 
- When you choose a city (via clicking), the application should add a city to the list (you can show a progress indicator in the process) and return to the cities screen

#### Detailed weather screen 
- Use [ViewPager2](https://developer.android.com/guide/navigation/navigation-swipe-view-2) and [TabLayout](https://developer.android.com/guide/navigation/navigation-swipe-view-2) to implement three tabs: today, tomorrow, several days (e.g. week) 
- Use [Fragments](https://developer.android.com/guide/fragments) for tabs 
- Use [SwipeRefreshLayout](https://developer.android.com/training/swipe/add-swipe-interface) to update data 
- Data for UI must be loaded from the database, data in the database must be updated using the API 
- Tabs for today and tomorrow should display the details of the weather for the day. The tab should contain the current weather, day and night temperature, humidity, and pressure. The details of the weather depend on the capabilities of the API. 
   - It should also display the hourly weather in a short form (e.g. time, weather, temperature). You should use RecyclerView for this. 
- A tab for several days should contain weather information for several days in advance 
   - Use RecyclerView to display information by day 
   - The information should be detailed, close to the information from today's and tomorrow's inserts (based on API capabilities) 
   - (optional) Use click-to-expand cells to display additional information (such as hourly weather)   
   Use a library for this e.g. [ExpandableLayout](https://github.com/cachapa/ExpandableLayout) 
- Use images/icons on this screen (e.g. to display weather conditions) 
 -(optional) Use graphs to display weather dynamics   
 Use a charting library such as [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart) 

#### Current weather notification  
- Add features for selecting the current city 
   - Store the selected current city in [SharedPreferences](https://developer.android.com/training/data-storage/shared-preferences) 
      - You can use [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) instead 
   - The first city in the list can be considered current (for this, you need to implement a change in the order of cities). You can add the selection of the current city to the detailed weather screen, for example, as an item in the App Bar (working as a checkbox) 
- Periodically update the weather information for today for the current city, use [WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager) for this task 
   - Refresh data about once an hour if internet is available 
- When the data is received, display a silent [Notification](https://developer.android.com/guide/topics/ui/notifiers/notifications) with weather details (updating the existing one) 
   - Details should contain the name of the city, current temperature and the weather icon 
