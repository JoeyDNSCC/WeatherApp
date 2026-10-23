package com.example.weatherapp.data


data class CurrentWeather(
    val weather: String,
    val temp: Int,
    val feelsLike: Int,
    val windSpeed: Int,
    val windDirection: String,
    val resourceId: Int
)

