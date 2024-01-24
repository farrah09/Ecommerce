package com.fandroid.weather_data.remote.dto

import com.squareup.moshi.Json

data class SearchDto(

    @field:Json(name = "latitude")
    val latitude: Double,
    @field:Json(name = "longitude")
    val  longitude: Double,
    @field:Json(name = "generationtime_ms")
    val  generationtimeMs: Double,
    @field:Json(name = "utc_offset_seconds")
    val utcOffsetSeconds: Int,
    @field:Json(name = "timezone")
    val timezone: String,
    @field:Json(name = "timezone_abbreviation")
    val timezoneAbbreviation: String,
    @field:Json(name = "elevation")
    val elevation: Int,
    @field:Json(name = "current_units")
    val currentUnits: CurrentUnits,
    @field:Json(name = "current")
    val current: Current,
    @field:Json(name = "hourly_units")
    val hourlyUnits: HourlyUnits,
    @field:Json(name = "hourly")
    val hourly: Hourly,
    @field:Json(name = "daily_units")
    val dailyUnits: DailyUnits,
    @field:Json(name = "daily")
    val daily: Daily

)

