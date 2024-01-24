package com.fandroid.weather_data.local

import androidx.room.*
import com.fandroid.weather_data.local.entity.WeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weatherEntity: WeatherEntity)

    @Delete
    suspend fun deleteWeather(weatherEntity: WeatherEntity)

    @Query(
        """
            SELECT *
            FROM weather
        """
    )
    fun getWeatherForDate(): Flow<List<WeatherEntity>>
}