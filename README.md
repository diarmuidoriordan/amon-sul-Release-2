# amon-sul-Release-2
 ###_Version 4 of the WeatherTop veiwing app_

## New Features:

- [x] **User Accounts** System:
    - [x] Register
    - [x] Login
    - [x] View own Stations & readings
    - [x] Logout
  
  
- [x] **GPS Location** of Station:
    - [x] Latitude
    - [x] Longitude
  

- [x] **Current Weather Icons**:
    -[x] Context Sensitive
  

- [x] **Maximum and Minimum** Readings for:
    - [x] Temperature
    - [x] Wind Speed
    - [x] Pressure
  
## Description:

In this version the user can register to create an account, 
sign in and view their weather stations. The user can log out when finished.

The user can then create as many new Stations as they want,
and populate each station with as many readings as they want.

In this version, a Station must be created with its GPS position entered in
Decimal Degrees. This information will be displayed on the Station 
Summary/Latest Readings cards.

Another new feature added to these cards is the Max/Min Readings, which
show the highest and lowest Readings recorded at the Station for each of
the Temperature, Wind Speed and Pressure variables.

Icons have also been added to these cards, and the Weather icon changes
with a different icon appropriate to the most recent weather code reading.

##Fixed Issues:

Users can no longer create multiple Stations with the same name. If the User
attempts to create a new Station with the same name as an existing
one, an error will be detected, the action will be cancelled and the User
will be redirected to their Stations Dashboard.

## How to Run:

Download the repository from GitHub:

* [Amon Sul Release 2 (Version 4)](https://github.com/diarmuidoriordan/amon-sul-Release-2)

_(Make sure you have [Play 1.5.3](https://www.playframework.com/releases) installed on your computer.)_

Navigate to the Project folder in _**Terminal**_ or the _**Command Prompt**_, and run the following commands:

* ```play idealize```

* ```play run```

In your browser, enter ```localhost:9000``` in the URL search bar. 
Press the return key on your keyboard to view the project.
