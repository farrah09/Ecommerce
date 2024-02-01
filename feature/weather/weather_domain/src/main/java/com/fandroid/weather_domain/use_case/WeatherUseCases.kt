package com.fandroid.weather_domain.use_case

data class WeatherUseCases(
    val getCurrentLocationUseCase: GetCurrentLocationUseCase,

    val getWeatherForLocationUseCase: GetWeatherForLocationUseCase
)
