package com.example.weatherapp.data

data class Weather (
    val weather: String,
    val temp: Int,
    val feelsLike: Int,
    val windSpeed: Int,
    val windDirection: String,
    val resourceId: Int
    )