package com.fandroid.weather_domain.repository

import com.fandroid.weather_domain.model.Weather
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface WeatherRepository {

    suspend fun searchWeather(
        latitude: Double,
        longitude: Double
    ): Result<Weather>

    suspend fun insertWeather(food: Weather)

    suspend fun deleteWeather(food: Weather)

    fun getCurrentWeather(latitude: Double, longitude: Double): Flow<Weather>
}