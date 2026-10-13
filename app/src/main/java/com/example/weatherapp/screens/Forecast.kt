package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.models.DailyWeather
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


@Composable
fun Forecast() {
    val forecast = remember {
        val today = LocalDate.now()

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
                resourceId = R.drawable.outline_rainy_heavy_24
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
                resourceId = R.drawable.outline_rainy_light_24
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
                resourceId = R.drawable.outline_cloud_24
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
                resourceId = R.drawable.outline_partly_cloudy_day_24
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
                resourceId = R.drawable.outline_rainy_24
            ),
            DailyWeather(
                date = today.plusDays(5),
                tempHigh = 18,
                tempLow = 9,
                weather = "Sunny",
                precipitationChance = 15,
                precipitationAmount = 0.0,
                maxWind = 20,
                humidity = 44,
                resourceId = R.drawable.outline_sunny_24
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
                resourceId = R.drawable.outline_rainy_light_24
            )
        )
    }

    val dateFormatter = DateTimeFormatter.ofPattern(
        "EEE, MMM d",
        Locale.ENGLISH
    )

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(items = forecast) { day ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor =
                        MaterialTheme.colorScheme.surface
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = day.date.format(dateFormatter),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold
                            )

                            Text(
                                text = day.weather,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Image(
                            painter = painterResource(
                                id = day.resourceId
                            ),
                            contentDescription = day.weather,
                            modifier = Modifier.size(48.dp)
                        )

                        Spacer(modifier = Modifier.size(12.dp))

                        Text(
                            text = "${day.tempHigh}° / ${day.tempLow}°",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column {
                            Text(
                                text = "Rain chance",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Text(
                                text = "${day.precipitationChance}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium
                            )
                        }
                        Column {
                            Text(
                                text = "Rainfall",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Text(
                                text = "${day.precipitationAmount}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column {
                            Text(
                                text = "Max wind",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Text(
                                text = "${day.maxWind}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        Column {
                            Text(
                                text = "Humidity",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Text(
                                text = "${day.humidity}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium
                            )
                        }

                    }
                }
            }
        }
    }
}
