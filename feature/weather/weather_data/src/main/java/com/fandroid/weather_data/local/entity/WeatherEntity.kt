package com.fandroid.weather_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fandroid.weather_data.remote.dto.Current
import com.fandroid.weather_data.remote.dto.CurrentUnits
import com.fandroid.weather_data.remote.dto.Daily
import com.fandroid.weather_data.remote.dto.DailyUnits
import com.fandroid.weather_data.remote.dto.Hourly
import com.fandroid.weather_data.remote.dto.HourlyUnits

@Entity(tableName = "weather")
data class WeatherEntity(
    val latitude: String,
    val longitude: Int,
    val generationtime_ms: Int,
    val utc_offset_seconds: Int,
    val timezone: String?,
    val elevation: String,
    val current: Current,
    val current_units: CurrentUnits,
    val hourly: Hourly,
    val hourly_units: HourlyUnits,
    val daily: Daily,
    val daily_units: DailyUnits,
    @PrimaryKey val id: Int? = null
)
