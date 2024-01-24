package com.fandroid.weather_presentation.model



data class Weather(
    val temperature: Int,
    val date: String,
    val wind: Int,
    val humidity: Int,
    val feelsLike: Int,
    val uv: Int,
    val name: String,
    val forecasts: List<Forecast>
)
