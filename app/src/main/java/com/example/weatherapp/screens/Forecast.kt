package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.weatherapp.R
import com.example.weatherapp.models.DailyWeather
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


@Composable
fun Forecast() {
    val today = LocalDate.now()

    // Generated dummy data then applied proper icons
    listOf(
        DailyWeather(
            date = today,
            tempHigh = 10,
            tempLow = 3,
            weather = "Heavy rain",
            precipitationChance = 76,
            precipitationAmount = 52.39,
            maxWind = 41,
            humidity = 96,
            resourceId = R.drawable.rain_icon_v1
        ),
        DailyWeather(
            date = today.plusDays(1),
            tempHigh = 12,
            tempLow = 5,
            weather = "Light rain",
            precipitationChance = 65,
            precipitationAmount = 12.5,
            maxWind = 30,
            humidity = 85,
            resourceId = R.drawable.rain_icon_v1
        ),
        DailyWeather(
            date = today.plusDays(2),
            tempHigh = 14,
            tempLow = 6,
            weather = "Cloudy",
            precipitationChance = 20,
            precipitationAmount = 1.0,
            maxWind = 22,
            humidity = 75,
            resourceId = R.drawable.rain_icon_v1
        ),
        DailyWeather(
            date = today.plusDays(3),
            tempHigh = 16,
            tempLow = 8,
            weather = "Partly cloudy",
            precipitationChance = 10,
            precipitationAmount = 0.0,
            maxWind = 18,
            humidity = 65,
            resourceId = R.drawable.rain_icon_v1
        ),
        DailyWeather(
            date = today.plusDays(4),
            tempHigh = 13,
            tempLow = 7,
            weather = "Showers",
            precipitationChance = 55,
            precipitationAmount = 8.2,
            maxWind = 35,
            humidity = 88,
            resourceId = R.drawable.rain_icon_v1
        ),
        DailyWeather(
            date = today.plusDays(5),
            tempHigh = 15,
            tempLow = 9,
            weather = "Overcast",
            precipitationChance = 15,
            precipitationAmount = 0.0,
            maxWind = 20,
            humidity = 72,
            resourceId = R.drawable.rain_icon_v1
        ),
        DailyWeather(
            date = today.plusDays(6),
            tempHigh = 17,
            tempLow = 10,
            weather = "Light rain",
            precipitationChance = 40,
            precipitationAmount = 3.4,
            maxWind = 25,
            humidity = 80,
            resourceId = R.drawable.rain_icon_v1
        )
    )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = day.date.format(DateTimeFormatter.ofPattern("EEE, MMM. d", Locale.ENGLISH)),
                style = MaterialTheme.typography.labelSmall
            )

            Image(
                painter = painterResource(id = day.resourceId),
                contentDescription = day.weather
            )
        }



    }
}