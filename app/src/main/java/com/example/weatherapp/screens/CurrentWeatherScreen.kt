package com.example.weatherapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.clearText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.weatherapp.MainViewModel
import kotlin.math.roundToInt


@Composable
fun CurrentWeatherScreen(viewModel: MainViewModel) {

    val weather = viewModel.weather
    //val searchTextFieldState = rememberTextFieldState(initialText = "")

//    LaunchedEffect(Unit) {
//        viewModel.loadWeatherIfNeeded("Halifax,NS")
//    }

//    if (weather != null) {
    weather?.let {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            AsyncImage(
                model = "https:${it.current.condition.icon}",
                contentDescription = it.current.condition.text,
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "${it.current.tempC.roundToInt()}°C",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = it.current.condition.text,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Feels like ${it.current.feelsLikeC}°C",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = "Wind ${it.current.windDirection} ${it.current.windKph.roundToInt()} km/h",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

             Spacer(modifier = Modifier.height(48.dp))

        }

    } ?: run {
        Column() {
            Text("There was an issue with the API")
        }
    }
}



