package com.example.weatherapp.models

import java.time.LocalDate

class DailyWeather(
    val date: LocalDate,
    val tempHigh: Int,
    val tempLow: Int,
    val weather: String,
    val precipitationChance: Int,
    val precipitationAmount: Number,
    val maxWind: Int,
    val humidity: Int,
    val resourceId: Int
)