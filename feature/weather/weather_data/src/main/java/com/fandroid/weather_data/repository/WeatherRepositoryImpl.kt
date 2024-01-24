package com.fandroid.weather_data.repository

import com.fandroid.weather_data.local.WeatherDao
import com.fandroid.weather_data.mapper.toWeather
import com.fandroid.weather_data.remote.OpeWeatherApi
import com.fandroid.weather_domain.model.Weather
import com.fandroid.weather_domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class WeatherRepositoryImpl(
    private val dao: WeatherDao,
    private val api: OpeWeatherApi
): WeatherRepository {

    override suspend fun searchWeather(
        latitude: Double,
        longitude: Double
    ): Result<Weather> {
        return try {
            val searchDto = api.searchWeather(
                latitude = latitude,
                longitude = longitude
            )
            Result.success(
                searchDto.toWeather()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun insertWeather(food: Weather) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWeather(food: Weather) {
        TODO("Not yet implemented")
    }

    override fun getWeatherForDate(localDate: LocalDate): Flow<List<Weather>> {
        TODO("Not yet implemented")
    }
}