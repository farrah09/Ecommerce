package com.fandroid.weather_data.remote.dto

data class Hourly(

    val time: List<String>,
    val temperature2m: List<String>

)

data class HourlyUnits(

    val time: String,
    val temperature2m: String

)