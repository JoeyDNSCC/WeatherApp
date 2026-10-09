package com.example.weatherapp.models

data class CurrentWeather(
    val location: String,
    val weather: String,
    val temp: Int,
    val feelsLike: Int,
    val windSpeed: Int,
    val windDirection: String,
    val resourceId: Int
)

