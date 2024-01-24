package com.fandroid.weather_data.remote.dto

import com.squareup.moshi.Json

data class Current(

    @field:Json(name = "time")
    val time: String,
    @field:Json(name = "interval")
    val interval : Int,
    @field:Json(name = "temperature_2m")
    val temperature2m: Double,
    @field:Json(name = "relative_humidity_2m")
    val relativeHumidity2m : Int,
    @field:Json(name = "apparent_temperature")
    val apparentTemperature :Double,
    @field:Json(name = "is_day")
    val isDay : Int,
    @field:Json(name = "precipitation")
    val precipitation: Int,
    @field:Json(name = "wind_speed_10m")
    val windSpeed10m: Int,
    @field:Json(name = "weather_code")
    val weather_code: Int

)

data class CurrentUnits(

    @field:Json(name = "time")
    val time: String,
    @field:Json(name = "interval")
    val interval : Int,
    @field:Json(name = "temperature_2m")
    val temperature2m: Double,
    @field:Json(name = "relative_humidity_2m")
    val relativeHumidity2m : Int,
    @field:Json(name = "apparent_temperature")
    val apparentTemperature :Double,
    @field:Json(name = "is_day")
    val isDay : Int,
    @field:Json(name = "precipitation")
    val precipitation: Int,
    @field:Json(name = "wind_speed_10m")
    val windSpeed10m: Int,
    @field:Json(name = "weather_code")
    val weather_code: String

)