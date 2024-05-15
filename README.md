# Interview Task App

This is an Android application developed as a part of an interview task. The app allows users to log in, view their current location on a map using Google Maps API, and fetch details of the logged-in user.

## Features

- User authentication: Allows users to log in securely.
- Display current location on a map.
- Fetch details from api .

## Installation

1. Clone the repository to your local machine:

    ```
    git clone https://github.com/your-username/interview-task-app.git
    ```

2. Open the project in Android Studio.

3. Build and run the project on an Android device or emulator.

## Usage

### Login
1. Upon launching the app, the user is presented with a login screen.
2. Enter valid credentials and tap the "Login" button to authenticate securely.

### Home Screen
- After successful login, the user is directed to the home screen.
- The home screen displays a list of users fetched from an API.
- Users can scroll through the list to view user details.

### Current Location
- The home screen contains a button to view the user's current location on a map.
- Tapping the "Show Current Location" button will open a map view displaying the user's current location.
- The app will prompt the user to grant location permissions if not already granted.
- The user can view their current location details on the map.

### Logout
- The home screen also contains a button to log out.
- Tapping the "Logout" button will log the user out of the app and redirect them to the login screen.


## Screenshots


<img src="https://github.com/trigon27/Interview_task/assets/133361109/dfd558ab-d54d-4c7d-8b9b-6c69de2718fe" alt="Alt text" width="300"/>
<img src="https://github.com/trigon27/Interview_task/assets/133361109/d7b87e17-4f22-4559-bc45-02be6fbbde7c" alt="Alt text" width="300"/>
<img src="https://github.com/trigon27/Interview_task/assets/133361109/7e882400-8e73-4ce9-970b-ad8c49712aac" alt="Alt text" width="300"/>
<img src="https://github.com/trigon27/Interview_task/assets/133361109/d224ed9a-ca2f-4980-9053-849d9e481cbb" alt="Alt text" width="300"/>


## Technologies Used

- Kotlin
- Android SDK
- Google Maps API
- Retrofit (for networking)
- Glide (for image loading)

## License

This project is licensed under the [MIT License](LICENSE).
