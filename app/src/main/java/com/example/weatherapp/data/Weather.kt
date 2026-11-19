package com.example.weatherapp.data

import com.google.gson.annotations.SerializedName

import java.math.BigInteger



data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Float,
    val lon: Float,
    @SerializedName("tz_id") val tzId: String,
    @SerializedName("localtime_epoch") val localtimeEpoch: BigInteger,
    val localtime: String
)
/*
Example used
id,

 */

data class Condition(
    val text: String,
    val icon: String,
    val code: Int
)


data class AirQuality(
    val co: Float,
    val no2: Float,
    val o3: Float,
    val so2: Float,
    @SerializedName("pm2_5") val pm25: Float,
    val pm10: Float,
    @SerializedName("us-epa-index") val usEpaIndex: Float,
    @SerializedName("gb-defra-index") val gbDefraIndex: Float
)


data class Current(
    @SerializedName("last_updated_epoch") val lastUpdatedEpoch: BigInteger,
    @SerializedName("last_updated") val lastUpdated: String,
    @SerializedName("temp_c") val tempC: Float,
    @SerializedName("temp_f") val tempF: Float,
    @SerializedName("is_day") val isDay: Float,
    val condition: Condition,
    @SerializedName("wind_mph") val windMph: Float,
    @SerializedName("wind_kph") val windKph: Float,
    @SerializedName("wind_degree") val windDegree: Float,
    @SerializedName("wind_dir") val windDirection: String,
    @SerializedName("pressure_mb") val pressureMb: Float,
    @SerializedName("pressure_in") val pressureIn: Float,
    @SerializedName("precip_mm") val precipitationMm: Float,
    @SerializedName("precip_in") val precipitationIn: Float,
    val humidity: Float,
    val cloud: Float,
    @SerializedName("feelslike_c") val feelsLikeC: Float,
    @SerializedName("feelslike_f") val feelsLikeF: Float,
    @SerializedName("windchill_c") val windChillC: Float,
    @SerializedName("windchill_f") val windChillF: Float,
    @SerializedName("heatindex_c") val heatIndexC: Float,
    @SerializedName("heatindex_f") val heatIndexF: Float,
    @SerializedName("dewpoint_c") val dewPointC: Float,
    @SerializedName("dewpoint_f") val dewPointF: Float,
    @SerializedName("vis_km") val visKm: Float,
    @SerializedName("vis_miles") val visMiles: Float,
    val uv: Float,
    @SerializedName("gust_mph") val gustMph: Float,
    @SerializedName("gust_kph") val gustKph: Float,
    @SerializedName("will_it_rain") val willItRain: Int,
    @SerializedName("chance_of_rain") val chanceOfRain: Int,
    @SerializedName("will_it_snow") val willItSnow: Int,
    @SerializedName("chance_of_snow") val chanceOfSnow: Int,
    @SerializedName("wetbulb_c") val wetBulbC: Float,
    @SerializedName("wetbulb_f") val wetBulbF: Float,
    @SerializedName("air_quality") val airQuality: AirQuality,
    @SerializedName("short_rad") val shortRad: Float,
    @SerializedName("diff_rad") val diffRad: Float,
    val dni: Float,
    val gti: Float
)


data class Day(
    @SerializedName("maxtemp_c") val maxTempC: Float,
    @SerializedName("maxtemp_f") val maxTempF: Float,
    @SerializedName("mintemp_c") val minTempC: Float,
    @SerializedName("mintemp_f") val minTempF: Float,
    @SerializedName("avgtemp_c") val avgTempC: Float,
    @SerializedName("avgtemp_f") val avgTempF: Float,
    @SerializedName("maxwind_mph") val maxWindMph: Float,
    @SerializedName("maxwind_kph") val maxWindKph: Float,
    @SerializedName("totalprecip_mm") val totalPrecipitationMm: Float,
    @SerializedName("totalprecip_in") val totalPrecipitationIn: Float,
    @SerializedName("totalsnow_cm") val totalSnowCm: Float,
    @SerializedName("avgvis_km") val avgVisibilityKm: Float,
    @SerializedName("avgvis_miles") val avgVisibilityMiles: Float,
    @SerializedName("avghumidity") val avgHumidity: Float,
    @SerializedName("daily_will_it_rain") val dailyWillItRain: Int,
    @SerializedName("daily_chance_of_rain") val dailyChanceOfRain: Int,
    @SerializedName("daily_will_it_snow") val dailyWillItSnow: Int,
    @SerializedName("daily_chance_of_snow") val dailyChanceOfSnow: Int,
    val condition: Condition,
    val uv: Float,
    @SerializedName("avgwetbulb_c") val avgWetBulbC: Float,
    @SerializedName("avgwetbulb_f") val avgWetBulbF: Float,
    @SerializedName("maxwetbulb_c") val maxWetBulbC: Float,
    @SerializedName("maxwetbulb_f") val maxWetBulbF: Float,
    @SerializedName("air_quality") val airQuality: AirQuality
)


data class Astro(
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,
    @SerializedName("moon_phase") val moonPhase: String,
    @SerializedName("moon_illumination") val moonIllumination: Float,
    @SerializedName("is_moon_up") val isMoonUp: Float,
    @SerializedName("is_sun_up") val isSunUp: Int
)


data class Hour(
    @SerializedName("time_epoch") val timeEpoch: BigInteger,
    val time: String,
    @SerializedName("temp_c") val tempC: Float,
    @SerializedName("temp_f") val tempF: Float,
    @SerializedName("is_day") val isDay: Float,
    val condition: Condition,
    @SerializedName("wind_mph") val windMph: Float,
    @SerializedName("wind_kph") val windKph: Float,
    @SerializedName("wind_degree") val windDegree: Float,
    @SerializedName("wind_dir") val windDir: String,
    @SerializedName("pressure_mb") val pressureMb: Float,
    @SerializedName("pressure_in") val pressureIn: Float,
    @SerializedName("precip_mm") val precipMm: Float,
    @SerializedName("precip_in") val precipIn: Float,
    @SerializedName("snow_cm") val snowCm: Float,
    val humidity: Float,
    val cloud: Float,
    @SerializedName("feelslike_c") val feelslikeC: Float,
    @SerializedName("feelslike_f") val feelslikeF: Float,
    @SerializedName("windchill_c") val windchillC: Float,
    @SerializedName("windchill_f") val windchillF: Float,
    @SerializedName("heatindex_c") val heatindexC: Float,
    @SerializedName("heatindex_f") val heatindexF: Float,
    @SerializedName("dewpoint_c") val dewpointC: Float,
    @SerializedName("dewpoint_f") val dewpointF: Float,
    @SerializedName("will_it_rain") val willItRain: Int,
    @SerializedName("chance_of_rain") val chanceOfRain: Int,
    @SerializedName("will_it_snow") val willItSnow: Int,
    @SerializedName("chance_of_snow") val chanceOfSnow: Int,
    @SerializedName("vis_km") val visKm: Float,
    @SerializedName("vis_miles") val visMiles: Float,
    @SerializedName("gust_mph") val gustMph: Float,
    @SerializedName("gust_kph") val gustKph: Float,
    val uv: Float,
    @SerializedName("wetbulb_c") val wetbulbC: Float,
    @SerializedName("wetbulb_f") val wetbulbF: Float,
    @SerializedName("air_quality") val airQuality: AirQuality,
    @SerializedName("short_rad") val shortRad: Float,
    @SerializedName("diff_rad") val diffRad: Float,
    val dni: Float,
    val gti: Float
)


data class ForecastDay(
    val date: String,
    @SerializedName("date_epoch") val dateEpoch: BigInteger,
    val day: Day,
    val astro: Astro,
    val hour: List<Hour>
)


data class Forecast(
    @SerializedName("forecastday") val forecastDays: List<ForecastDay>
)


//data class Alerts(
//    val alert: List<Any>
//)


data class Weather(
    val location: Location,
    val current: Current,
    val forecast: Forecast,
//    val alerts: Alerts
)

