package com.fandroid.weather_data.remote.dto

import com.squareup.moshi.Json

data class Daily(

    @field:Json(name = "time")
    val time: List<String>,
    @field:Json(name = "temperature_2m_max")
    val temperature_2m_max: List<String>,
    @field:Json(name = "temperature_2m_min")
    val temperature_2m_min : List<String>,
    @field:Json(name = "sunrise")
    val sunrise :List<String>,
    @field:Json(name = "sunset")
    val sunset :List<String>,

)

data class DailyUnits(

    @field:Json(name = "time")
    val time: String,
    @field:Json(name = "temperature_2m_max")
    val temperature_2m_max: String,
    @field:Json(name = "temperature_2m_min")
    val temperature_2m_min : String,
    @field:Json(name = "sunrise")
    val sunrise :String,
    @field:Json(name = "sunset")
    val sunset :String,

)