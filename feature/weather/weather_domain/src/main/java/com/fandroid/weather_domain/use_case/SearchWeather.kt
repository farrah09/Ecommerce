package com.fandroid.weather_domain.use_case

import com.fandroid.weather_domain.model.Weather
import com.fandroid.weather_domain.repository.WeatherRepository

class SearchWeather(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(
        latitude: Double = 0.0,
        longitude: Double = 0.0
    ): Result<Weather> {
        return repository.searchWeather(latitude,longitude)
    }
}