package com.example.weatherapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.Weather

class MainViewModel: ViewModel() {
    /* properties*/

    // will be changed to full object eventually
    var location by mutableStateOf<Weather?>(value = null)

    init {

    }

    /* functions */

    //
    fun searchLocation(city: String) {

    }
}