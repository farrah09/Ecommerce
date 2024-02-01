package com.fandroid.weather_domain.use_case

import com.fandroid.weather_domain.model.Weather
import com.fandroid.weather_domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

class GetWeatherForLocationUseCase(
    private val repository: WeatherRepository
) {
    operator fun invoke(latitude: Double, longitude: Double): Flow<Weather> {
        return repository.getCurrentWeather(latitude,longitude)
    }
}
