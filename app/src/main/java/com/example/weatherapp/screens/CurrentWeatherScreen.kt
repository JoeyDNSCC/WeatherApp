package com.example.weatherapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.R

import com.example.weatherapp.data.CurrentWeather

@Composable
fun CurrentWeatherScreen(viewModel: MainViewModel) {

//    val locationSearch = viewModel.locationSearch

    val currentWeather = CurrentWeather(
        weather = "Partly cloudy",
        temp = 12,
        feelsLike = 9,
        windSpeed = 41,
        windDirection = "NW",
        resourceId = R.drawable.outline_partly_cloudy_day_24
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Image(
            painter = painterResource(
                id = currentWeather.resourceId
            ),
            contentDescription = currentWeather.weather,
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "${currentWeather.temp}°C",
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = currentWeather.weather,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Feels like ${currentWeather.feelsLike}°C",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = "Wind ${currentWeather.windDirection} ${currentWeather.windSpeed} km/h",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Column {
            Button(
                onClick = {
                    viewModel.searchLocation("Halifax")
                }
            ) {
                Text("Search Halifax")
            }
        }
        // Spacer(modifier = Modifier.height(48.dp))

    }
}



