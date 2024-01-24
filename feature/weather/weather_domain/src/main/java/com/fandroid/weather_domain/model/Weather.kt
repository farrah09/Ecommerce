package com.fandroid.weather_domain.model


data class Weather(
    val temperature: Int,
    val date: String,
    val wind: Int,
    val humidity: Int,
    val feelsLike: Int,
    val condition: Condition,
    val uv: Int,
    val name: String,
    val forecasts: List<Forecast>,
    val hour: List<Hour>
)

data class Condition(
    val code: Int,
    val icon: String,
    val text: String
)


data class Forecast(
    val date: String,
    val maxTemp: String,
    val minTemp: String,
    val sunrise: String,
    val sunset: String,
    val icon: String,
)

data class Hour(
    val time: String,
    val icon: String,
    val temperature: String,
)