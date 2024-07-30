
# Countries Application

This is a sample Android application to demonstrate the use of Jetpack components such as Navigation, ViewModel, LiveData, and Data Binding. The application displays a list of countries fetched from a remote API and provides details for each country.

## Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Libraries and Tools](#libraries-and-tools)
- [Setup](#setup)
- [Screenshots](#screenshots)
- [Commit History and Technical Details](#commit-history-and-technical-details)
- [Contributing](#contributing)
- [License](#license)

## Features

- Display a list of countries.
- Pull to refresh functionality.
- Navigate to the country details screen.
- Error handling with appropriate UI feedback.
- Utilizes ViewModel and LiveData for managing UI-related data.
- Uses Retrofit for networking and Coroutines for asynchronous operations.

## Architecture

The application follows the MVVM (Model-View-ViewModel) architecture pattern, which helps in separation of concerns and makes the codebase more maintainable and testable.

- **Model**: Represents the data layer. It includes the data source and repository pattern to fetch data from the API.
- **View**: Represents the UI layer. Activities, Fragments, and XML layouts form this layer.
- **ViewModel**: Acts as a bridge between the Model and the View. It holds and manages UI-related data.

## Libraries and Tools

- **Jetpack Components**: Navigation, ViewModel, LiveData, Data Binding.
- **Retrofit**: For network calls.
- **Coroutines**: For asynchronous operations.
- **Hilt**: For dependency injection.
- **SwipeRefreshLayout**: For pull-to-refresh functionality.
- **ConstraintLayout**: For designing complex layouts.

## Setup

To set up the project locally, follow these steps:

1. **Clone the repository**:

   ```bash
   git clone https://github.com/ezgifistikcioglu/Countries.git
   cd Countries
   ```

2. **Open the project in Android Studio**:

   - Ensure you have the latest version of Android Studio installed.
   - Open the project directory in Android Studio.

3. **Build the project**:

   - Sync the project with Gradle files.
   - Build the project to download all dependencies.

4. **Run the app**:

   - Connect an Android device or start an emulator.
   - Run the app from Android Studio.

## Commit History and Technical Details

### Initial Commit

- **Description**: Initial setup of the project with basic structure.
- **Technical Details**: Created the project with an empty activity and set up the basic directory structure.

### Added Navigation Component

- **Description**: Added Jetpack Navigation component to handle fragment navigation.
- **Technical Details**:
  - Added dependencies for Navigation component.
  - Created `NavHost` and `NavController` in the main activity.
  - Defined navigation graph with destinations for the list and detail fragments.

### Implemented ViewModel and LiveData

- **Description**: Integrated ViewModel and LiveData to manage UI-related data.
- **Technical Details**:
  - Created `CountryViewModel` to handle country data.
  - Used LiveData to observe data changes in the UI.
  - Implemented data fetching logic in ViewModel.

### Integrated Retrofit for Networking

- **Description**: Added Retrofit to handle API calls.
- **Technical Details**:
  - Added Retrofit and Coroutines dependencies.
  - Created `CountryApiService` for network requests.
  - Implemented repository pattern to fetch data from the API.

### Added SwipeRefreshLayout

- **Description**: Added SwipeRefreshLayout for pull-to-refresh functionality.
- **Technical Details**:
  - Added SwipeRefreshLayout in the XML layout.
  - Implemented refresh logic in the fragment to fetch data again.

### Error Handling and UI Feedback

- **Description**: Implemented error handling and UI feedback for network errors.
- **Technical Details**:
  - Displayed error messages using a TextView.
  - Used ProgressBar to show loading state.
  - Updated UI based on the data state (loading, success, error).

### Dependency Injection with Hilt

- **Description**: Integrated Hilt for dependency injection.
- **Technical Details**:
  - Added Hilt dependencies.
  - Created Hilt modules for providing dependencies.
  - Injected dependencies into ViewModel and other classes.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to create an issue or submit a pull request.

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature-name`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature/your-feature-name`).
6. Create a pull request.

