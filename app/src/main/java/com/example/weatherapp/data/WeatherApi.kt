package com.example.weatherapp.data

import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
    @GET("v1/forecast.json")
    suspend fun getWeather(
        @Query("key") key: String,
        @Query("q") query: String,
        @Query("days") days: Int = 2,
        @Query("aqi") aqi: String = "yes",
        @Query("alerts") alerts: String = "no"

    ): Weather
}