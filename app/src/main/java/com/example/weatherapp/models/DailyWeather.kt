package com.example.weatherapp.models

import java.time.LocalDate

class DailyWeather(
    // https://www.baeldung.com/kotlin/dates
    // this might break
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