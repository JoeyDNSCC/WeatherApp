package com.example.weatherapp

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.Weather
import com.example.weatherapp.data.WeatherApi
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.location.Location
import com.google.android.gms.location.Priority

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val fusedLocationClient =
        LocationServices.getFusedLocationProviderClient(app)

    var location by mutableStateOf<Location?>(null) // NOTE: import Android's built-in Location class  android.location.Location
        private set
    var isLoading by mutableStateOf(false)
        private set
    var weather by mutableStateOf<Weather?>(null) // DAO
        private set
    var error by mutableStateOf<String?>(null)
        private set

    private val api = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/") // API hostname
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherApi::class.java) // Interface

    fun getWeather(query: String) {
        // launch co-routine
        viewModelScope.launch {
            isLoading = true

            try {
                weather = api.getWeather(BuildConfig.API_KEY, query)
                error = null
            } catch(e: Exception){
                Log.e("MainViewModel","Weather API request failed", e)
                error = "The Location $query was not found. Try again!"
            } finally {
                isLoading = false
            }

        }
    }
    fun loadWeatherIfNeeded(query: String) {
        if (weather == null) {
            getWeather(query)
        }
    }
    @SuppressLint("MissingPermission") // silence warning
    fun refreshLocation() {
        isLoading = true
        error = null

        fusedLocationClient
            .getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null)
            .addOnSuccessListener { result ->

                if (result != null) {
                    location = result
                    val latlng = "${location?.latitude},${location?.longitude}"
                    Log.i("MainViewModel", "Device Location: $latlng.")

                    getWeather(latlng)
                }
                else {
                    isLoading = false
                    error = "Unable to retrieve device location"
                }
            }
            .addOnFailureListener { exception ->
                isLoading = false
                error = exception.message ?: "Location request failed"
            }
    }
}