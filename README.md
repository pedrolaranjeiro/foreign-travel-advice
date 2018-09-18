# foreign-travel-advice
Shows a list of countries and travel advise for each.

## Purpose
Test application that gets information from https://www.gov.uk/api/content/foreign-travel-advice and show advice for each country represented in the URL.

## How to run the App
To run the app, open the project on Android Studio, go to "Run" menu and press "Run 'app'"


## Architecture
This project uses clean architecture structure that consists in 3 layers:
- DATA,
- DOMAIN,
- PRESENTATION

Each layer is only aware of the layer above. The layers provide an interface to be consumed and to hide all implementation specific code. This way, the internal logic can change and it won't affect the classes consuming the services.

### DATA Layer
The classes in data layer are responsible to collect the information. In this particular case, the information will be fetched from a website but can easily be adapted to get it from a database or other sources.

### DOMAIN Layer
This layer contains the business logic. It gets information from the data layer, processes it and deliver in easy to consume wat to the Presentation layer.

### PRESENTATION Layer
The Android components live in this layer. All it does is to populate the views, handle clicks and show view related content. It is a "dumb layer" because it does not have any business logic. 

There are a few advantages of using this structure. The principal is that it makes testing easier because it clearly separates the view components from the logic ones. All logic is in Plain Old Java Objects.

## Frameworks Used
* Retrofit 
* RxJava
* Kotlin
* Gson

## Improvements
* Pull list to update
* Injection using Kodein
* Add more tests
* Cache results to avoid contacting the url every time
* Improve UI using material design guidelines
* Add animations
* Add user clicks feedback
* Migrate presentation layer to new Google Navigation Pattern
* Better error handling

## Why there aren't any comments in the code?
The code should be clear enough that any developer understands what is happening. The package organization should show the architecture used and what the app does. The methods should be clear and do one thing only. If a part of the code needs comments, maybe that part is confusing and needs to be rethinked.

